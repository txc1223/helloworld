package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.CalendarGroup;

 public  class GetCustomCalendarGroupListResponse extends Response {
 
private CalendarGroup[] calendarGroup;
public void setCalendarGroup(CalendarGroup[] calendarGroup){
this.calendarGroup=calendarGroup;
}
public CalendarGroup[] getCalendarGroup(){
return calendarGroup;
}
 
} 