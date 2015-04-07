package com.beyondbit.smartbox.request;
 public  class FindDeptCalendarsRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String deptCode;
public void setDeptCode(String deptCode){
this.deptCode=deptCode;
}
public String getDeptCode(){
return deptCode;
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