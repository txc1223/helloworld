package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.Calendar;

import java.io.Serializable;
 public  class CalendarList  implements Serializable{
 
private Calendar[] calendar;
private boolean hasCalendar=false;
public boolean getHasCalendar(){
return hasCalendar;
}
public void setHasCalendar(boolean hasCalendar){
this.hasCalendar=hasCalendar;
}
public void setCalendar(Calendar[] calendar){
this.hasCalendar=true;
this.calendar=calendar;
}
public Calendar[] getCalendar(){
return calendar;
}
 
} 