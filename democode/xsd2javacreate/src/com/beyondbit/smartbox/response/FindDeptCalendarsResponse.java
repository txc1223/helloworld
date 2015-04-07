package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.Calendar;

 public  class FindDeptCalendarsResponse extends Response {
 
private Calendar[] calendar;
public void setCalendar(Calendar[] calendar){
this.calendar=calendar;
}
public Calendar[] getCalendar(){
return calendar;
}
 
} 