package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.DetailCalendar;

 public  class UpdateCalendarRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String calendarType;
public void setCalendarType(String calendarType){
this.calendarType=calendarType;
}
public String getCalendarType(){
return calendarType;
}
 
private DetailCalendar detailCalendar;
public void setDetailCalendar(DetailCalendar detailCalendar){
this.detailCalendar=detailCalendar;
}
public DetailCalendar getDetailCalendar(){
return detailCalendar;
}
 
} 