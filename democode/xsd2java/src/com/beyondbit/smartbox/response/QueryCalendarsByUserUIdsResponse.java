package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.UserCalendar;

import java.io.Serializable;
 public  class QueryCalendarsByUserUIdsResponse extends Response  implements Serializable{
 
private UserCalendar[] userCalendar;
private boolean hasUserCalendar=false;
public boolean getHasUserCalendar(){
return hasUserCalendar;
}
public void setHasUserCalendar(boolean hasUserCalendar){
this.hasUserCalendar=hasUserCalendar;
}
public void setUserCalendar(UserCalendar[] userCalendar){
this.hasUserCalendar=true;
this.userCalendar=userCalendar;
}
public UserCalendar[] getUserCalendar(){
return userCalendar;
}
 
} 