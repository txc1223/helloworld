package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.DetailCalendar;

import java.io.Serializable;
 public  class UpdateCalendarRequest extends Request  implements Serializable{
 
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
 private String calendarType;
private boolean hasCalendarType=false;
public boolean getHasCalendarType(){
return hasCalendarType;
}
public void setHasCalendarType(boolean hasCalendarType){
this.hasCalendarType=hasCalendarType;
}
public void setCalendarType(String calendarType){
this.hasCalendarType=true;
this.calendarType=calendarType;
}
public String getCalendarType(){
return calendarType;
}
 
private DetailCalendar detailCalendar;
private boolean hasDetailCalendar=false;
public boolean getHasDetailCalendar(){
return hasDetailCalendar;
}
public void setHasDetailCalendar(boolean hasDetailCalendar){
this.hasDetailCalendar=hasDetailCalendar;
}
public void setDetailCalendar(DetailCalendar detailCalendar){
this.hasDetailCalendar=true;
this.detailCalendar=detailCalendar;
}
public DetailCalendar getDetailCalendar(){
return detailCalendar;
}
 
} 