package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.CalendarList;

import java.io.Serializable;
 public  class UserCalendar  implements Serializable{
 
private String userUid;
private boolean hasUserUid=false;
public boolean getHasUserUid(){
return hasUserUid;
}
public void setHasUserUid(boolean hasUserUid){
this.hasUserUid=hasUserUid;
}
public void setUserUid(String userUid){
this.hasUserUid=true;
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
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