package com.beyondbit.smartbox.common;
 public  class DetailCalendar extends Calendar {
 private String instanceType="1";
public void setInstanceType(String instanceType){
this.instanceType=instanceType;
}
public String getInstanceType(){
return instanceType;
}
 private String userID;
public void setUserID(String userID){
this.userID=userID;
}
public String getUserID(){
return userID;
}
 private String body;
public void setBody(String body){
this.body=body;
}
public String getBody(){
return body;
}
 private String otherAttendees;
public void setOtherAttendees(String otherAttendees){
this.otherAttendees=otherAttendees;
}
public String getOtherAttendees(){
return otherAttendees;
}
 private String recurring;
public void setRecurring(String recurring){
this.recurring=recurring;
}
public String getRecurring(){
return recurring;
}
 private String deptId;
public void setDeptId(String deptId){
this.deptId=deptId;
}
public String getDeptId(){
return deptId;
}
 private String deptName;
public void setDeptName(String deptName){
this.deptName=deptName;
}
public String getDeptName(){
return deptName;
}
 private String catagories;
public void setCatagories(String catagories){
this.catagories=catagories;
}
public String getCatagories(){
return catagories;
}
 private String isReminder;
public void setIsReminder(String isReminder){
this.isReminder=isReminder;
}
public String getIsReminder(){
return isReminder;
}
 private int reminderOffset;
private boolean hasReminderOffset=false;
public boolean getHasReminderOffset(){
return hasReminderOffset;
}
public void setHasReminderOffset(boolean hasReminderOffset){
this.hasReminderOffset=hasReminderOffset;
}
public void setReminderOffset(int reminderOffset){
this.hasReminderOffset=true;
this.reminderOffset=reminderOffset;
}
public int getReminderOffset(){
return reminderOffset;
}
 private String reminderType;
public void setReminderType(String reminderType){
this.reminderType=reminderType;
}
public String getReminderType(){
return reminderType;
}
 
} 