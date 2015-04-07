package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.CalendarList;

 public  class UserCalendar {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 
private CalendarList calendarList;
public void setCalendarList(CalendarList calendarList){
this.calendarList=calendarList;
}
public CalendarList getCalendarList(){
return calendarList;
}
 
} 