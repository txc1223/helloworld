package com.beyondbit.smartbox.request;
 public  class QueryCalendarsByUserUIdsRequest extends Request {
 private String userUids;
public void setUserUids(String userUids){
this.userUids=userUids;
}
public String getUserUids(){
return userUids;
}
 private java.util.Calendar viewStartTime;
public void setViewStartTime(java.util.Calendar viewStartTime){
this.viewStartTime=viewStartTime;
}
public java.util.Calendar getViewStartTime(){
return viewStartTime;
}
 private java.util.Calendar viewEndTime;
public void setViewEndTime(java.util.Calendar viewEndTime){
this.viewEndTime=viewEndTime;
}
public java.util.Calendar getViewEndTime(){
return viewEndTime;
}
 
} 