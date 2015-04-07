package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.DetailCalendar;

 public  class AddCalendarRequest extends Request {
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