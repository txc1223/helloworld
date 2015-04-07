package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.Calendar;

import java.io.Serializable;
 public  class FindDeptCalendarsResponse extends Response  implements Serializable{
 
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