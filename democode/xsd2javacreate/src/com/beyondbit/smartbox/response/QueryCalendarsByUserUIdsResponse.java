package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.UserCalendar;

 public  class QueryCalendarsByUserUIdsResponse extends Response {
 
private UserCalendar[] userCalendar;
public void setUserCalendar(UserCalendar[] userCalendar){
this.userCalendar=userCalendar;
}
public UserCalendar[] getUserCalendar(){
return userCalendar;
}
 
} 