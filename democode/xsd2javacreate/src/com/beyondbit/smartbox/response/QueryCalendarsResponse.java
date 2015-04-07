package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.Calendar;

 public  class QueryCalendarsResponse extends Response {
 
private Calendar[] calendar;
public void setCalendar(Calendar[] calendar){
this.calendar=calendar;
}
public Calendar[] getCalendar(){
return calendar;
}
 private int contactTotal;
public void setContactTotal(int contactTotal){
this.contactTotal=contactTotal;
}
public int getContactTotal(){
return contactTotal;
}
 
} 