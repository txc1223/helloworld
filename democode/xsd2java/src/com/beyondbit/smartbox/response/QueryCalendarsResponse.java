package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.Calendar;

import java.io.Serializable;
 public  class QueryCalendarsResponse extends Response  implements Serializable{
 
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
 private int contactTotal;
private boolean hasContactTotal=false;
public boolean getHasContactTotal(){
return hasContactTotal;
}
public void setHasContactTotal(boolean hasContactTotal){
this.hasContactTotal=hasContactTotal;
}
public void setContactTotal(int contactTotal){
this.hasContactTotal=true;
this.contactTotal=contactTotal;
}
public int getContactTotal(){
return contactTotal;
}
 
} 