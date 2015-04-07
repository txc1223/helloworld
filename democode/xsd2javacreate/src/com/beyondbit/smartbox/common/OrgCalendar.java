package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.CalendarList;

 public  class OrgCalendar {
 private String orgCode;
public void setOrgCode(String orgCode){
this.orgCode=orgCode;
}
public String getOrgCode(){
return orgCode;
}
 
private CalendarList calendarList;
public void setCalendarList(CalendarList calendarList){
this.calendarList=calendarList;
}
public CalendarList getCalendarList(){
return calendarList;
}
 
} 