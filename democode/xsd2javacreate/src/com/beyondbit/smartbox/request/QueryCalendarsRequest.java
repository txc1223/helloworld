package com.beyondbit.smartbox.request;
 public  class QueryCalendarsRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
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
 private String subject;
public void setSubject(String subject){
this.subject=subject;
}
public String getSubject(){
return subject;
}
 private int isPrecise;
public void setIsPrecise(int isPrecise){
this.isPrecise=isPrecise;
}
public int getIsPrecise(){
return isPrecise;
}
 private String calendarType;
public void setCalendarType(String calendarType){
this.calendarType=calendarType;
}
public String getCalendarType(){
return calendarType;
}
 private String deptCode;
public void setDeptCode(String deptCode){
this.deptCode=deptCode;
}
public String getDeptCode(){
return deptCode;
}
 private int pageSize;
public void setPageSize(int pageSize){
this.pageSize=pageSize;
}
public int getPageSize(){
return pageSize;
}
 private int pageIndex;
public void setPageIndex(int pageIndex){
this.pageIndex=pageIndex;
}
public int getPageIndex(){
return pageIndex;
}
 
} 