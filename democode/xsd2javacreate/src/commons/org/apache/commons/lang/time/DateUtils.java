/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package commons.org.apache.commons.lang.time;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.TimeZone;

import commons.org.apache.commons.lang.StringUtils;

/**
 * <p>A suite of utilities surrounding the use of the
 * {@link java.util.Calendar} and {@link java.util.Date} object.</p>
 * 
 * <p>DateUtils contains a lot of common methods considering manipulations
 * of Dates or Calendars. Some methods require some extra explanation.
 * The truncate, ceiling and round methods could be considered the Math.floor(),
 * Math.ceil() or Math.round versions for dates
 * This way date-fields will be ignored in bottom-up order.
 * As a complement to these methods we've introduced some fragment-methods.
 * With these methods the Date-fields will be ignored in top-down order.
 * Since a date without a year is not a valid date, you have to decide in what
 * kind of date-field you want your result, for instance milliseconds or days.
 * </p>
 *   
 *   
 *
 * @author Apache Software Foundation
 * @author <a href="mailto:sergek@lokitech.com">Serge Knystautas</a>
 * @author Janek Bogucki
 * @author <a href="mailto:ggregory@seagullsw.com">Gary Gregory</a>
 * @author Phil Steitz
 * @author Robert Scholte
 * @since 2.0
 * @version $Id: DateUtils.java 1056840 2011-01-09 00:12:23Z niallp $
 */
public class DateUtils {
    

    /**
     * <p><code>DateUtils</code> instances should NOT be constructed in
     * standard programming. Instead, the class should be used as
     * <code>DateUtils.parse(str);</code>.</p>
     *
     * <p>This constructor is public to permit tools that require a JavaBean
     * instance to operate.</p>
     */
    public DateUtils() {
        super();
    }


    //-----------------------------------------------------------------------
    /**
     * <p>Parses a string representing a date by trying a variety of different parsers.</p>
     * 
     * <p>The parse will try each parse pattern in turn.
     * A parse is only deemed successful if it parses the whole of the input string.
     * If no parse patterns match, a ParseException is thrown.</p>
     * The parser will be lenient toward the parsed date.
     * 
     * @param str  the date to parse, not null
     * @param parsePatterns  the date format patterns to use, see SimpleDateFormat, not null
     * @return the parsed date
     * @throws IllegalArgumentException if the date string or pattern array is null
     * @throws ParseException if none of the date patterns were suitable (or there were none)
     */
    public static Date parseDate(String str, String[] parsePatterns) throws ParseException {
        return parseDateWithLeniency(str, parsePatterns, true);
    }
    
  //-----------------------------------------------------------------------
    /**
     * <p>Parses a string representing a date by trying a variety of different parsers.</p>
     * 
     * <p>The parse will try each parse pattern in turn.
     * A parse is only deemed successful if it parses the whole of the input string.
     * If no parse patterns match, a ParseException is thrown.</p>
     * The parser parses strictly - it does not allow for dates such as "February 942, 1996". 
     * 
     * @param str  the date to parse, not null
     * @param parsePatterns  the date format patterns to use, see SimpleDateFormat, not null
     * @return the parsed date
     * @throws IllegalArgumentException if the date string or pattern array is null
     * @throws ParseException if none of the date patterns were suitable
     * @since 2.5
     */
    public static Date parseDateStrictly(String str, String[] parsePatterns) throws ParseException {
        return parseDateWithLeniency(str, parsePatterns, false);
    }

    /**
     * <p>Parses a string representing a date by trying a variety of different parsers.</p>
     * 
     * <p>The parse will try each parse pattern in turn.
     * A parse is only deemed successful if it parses the whole of the input string.
     * If no parse patterns match, a ParseException is thrown.</p>
     * 
     * @param str  the date to parse, not null
     * @param parsePatterns  the date format patterns to use, see SimpleDateFormat, not null
     * @param lenient Specify whether or not date/time parsing is to be lenient.
     * @return the parsed date
     * @throws IllegalArgumentException if the date string or pattern array is null
     * @throws ParseException if none of the date patterns were suitable
     * @see java.util.Calender#isLenient()
     */
    private static Date parseDateWithLeniency(String str, String[] parsePatterns,
            boolean lenient) throws ParseException {
        if (str == null || parsePatterns == null) {
            throw new IllegalArgumentException("Date and Patterns must not be null");
        }
        
        SimpleDateFormat parser = new SimpleDateFormat();
        parser.setLenient(lenient);
        ParsePosition pos = new ParsePosition(0);
        for (int i = 0; i < parsePatterns.length; i++) {

            String pattern = parsePatterns[i];

            // LANG-530 - need to make sure 'ZZ' output doesn't get passed to SimpleDateFormat
            if (parsePatterns[i].endsWith("ZZ")) {
                pattern = pattern.substring(0, pattern.length() - 1);
            }
            
            parser.applyPattern(pattern);
            pos.setIndex(0);

            String str2 = str;
            // LANG-530 - need to make sure 'ZZ' output doesn't hit SimpleDateFormat as it will ParseException
            if (parsePatterns[i].endsWith("ZZ")) {
                int signIdx  = indexOfSignChars(str2, 0);
                while (signIdx >=0) {
                    str2 = reformatTimezone(str2, signIdx);
                    signIdx = indexOfSignChars(str2, ++signIdx);
                }
            }

            Date date = parser.parse(str2, pos);
            if (date != null && pos.getIndex() == str2.length()) {
                return date;
            }
        }
        throw new ParseException("Unable to parse the date: " + str, -1);
    }

    /**
     * Index of sign charaters (i.e. '+' or '-').
     * 
     * @param str The string to search
     * @param startPos The start position
     * @return the index of the first sign character or -1 if not found
     */
    private static int indexOfSignChars(String str, int startPos) {
        int idx = StringUtils.indexOf(str, '+', startPos);
        if (idx < 0) {
            idx = StringUtils.indexOf(str, '-', startPos);
        }
        return idx;
    }

    /**
     * Reformat the timezone in a date string.
     *
     * @param str The input string
     * @param signIdx The index position of the sign characters
     * @return The reformatted string
     */
    private static String reformatTimezone(String str, int signIdx) {
        String str2 = str;
        if (signIdx >= 0 &&
            signIdx + 5 < str.length() &&
            Character.isDigit(str.charAt(signIdx + 1)) &&
            Character.isDigit(str.charAt(signIdx + 2)) &&
            str.charAt(signIdx + 3) == ':' &&
            Character.isDigit(str.charAt(signIdx + 4)) &&
            Character.isDigit(str.charAt(signIdx + 5))) {
            str2 = str.substring(0, signIdx + 3) + str.substring(signIdx + 4);
        }
        return str2;
    }








    
}
