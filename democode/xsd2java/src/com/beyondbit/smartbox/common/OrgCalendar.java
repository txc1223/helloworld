package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.CalendarList;

import java.io.Serializable;
 public  class OrgCalendar  implements Serializable{
 
private String orgCode;
private boolean hasOrgCode=false;
public boolean getHasOrgCode(){
return hasOrgCode;
}
public void setHasOrgCode(boolean hasOrgCode){
this.hasOrgCode=hasOrgCode;
}
public void setOrgCode(String orgCode){
this.hasOrgCode=true;
this.orgCode=orgCode;
}
public String getOrgCode(){
return orgCode;
}
 
private CalendarList calendarList;
private boolean hasCalendarList=false;
public boolean getHasCalendarList(){
return hasCalendarList;
}
public void setHasCalendarList(boolean hasCalendarList){
this.hasCalendarList=hasCalendarList;
}
public void setCalendarList(CalendarList calendarList){
this.hasCalendarList=true;
this.calendarList=calendarList;
}
public CalendarList getCalendarList(){
return calendarList;
}
 
} 