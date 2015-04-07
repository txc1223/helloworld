package com.beyondbit.smartbox.common;
import java.io.Serializable;
 public  class DetailCalendar extends Calendar  implements Serializable{
 
private String instanceType="1";
private boolean hasInstanceType=false;
public boolean getHasInstanceType(){
return hasInstanceType;
}
public void setHasInstanceType(boolean hasInstanceType){
this.hasInstanceType=hasInstanceType;
}
public void setInstanceType(String instanceType){
this.hasInstanceType=true;
this.instanceType=instanceType;
}
public String getInstanceType(){
return instanceType;
}
 private String userID;
private boolean hasUserID=false;
public boolean getHasUserID(){
return hasUserID;
}
public void setHasUserID(boolean hasUserID){
this.hasUserID=hasUserID;
}
public void setUserID(String userID){
this.hasUserID=true;
this.userID=userID;
}
public String getUserID(){
return userID;
}
 private String body;
private boolean hasBody=false;
public boolean getHasBody(){
return hasBody;
}
public void setHasBody(boolean hasBody){
this.hasBody=hasBody;
}
public void setBody(String body){
this.hasBody=true;
this.body=body;
}
public String getBody(){
return body;
}
 private String recurring;
private boolean hasRecurring=false;
public boolean getHasRecurring(){
return hasRecurring;
}
public void setHasRecurring(boolean hasRecurring){
this.hasRecurring=hasRecurring;
}
public void setRecurring(String recurring){
this.hasRecurring=true;
this.recurring=recurring;
}
public String getRecurring(){
return recurring;
}
 private String deptId;
private boolean hasDeptId=false;
public boolean getHasDeptId(){
return hasDeptId;
}
public void setHasDeptId(boolean hasDeptId){
this.hasDeptId=hasDeptId;
}
public void setDeptId(String deptId){
this.hasDeptId=true;
this.deptId=deptId;
}
public String getDeptId(){
return deptId;
}
 private String deptName;
private boolean hasDeptName=false;
public boolean getHasDeptName(){
return hasDeptName;
}
public void setHasDeptName(boolean hasDeptName){
this.hasDeptName=hasDeptName;
}
public void setDeptName(String deptName){
this.hasDeptName=true;
this.deptName=deptName;
}
public String getDeptName(){
return deptName;
}
 private String catagories;
private boolean hasCatagories=false;
public boolean getHasCatagories(){
return hasCatagories;
}
public void setHasCatagories(boolean hasCatagories){
this.hasCatagories=hasCatagories;
}
public void setCatagories(String catagories){
this.hasCatagories=true;
this.catagories=catagories;
}
public String getCatagories(){
return catagories;
}
 private String isReminder;
private boolean hasIsReminder=false;
public boolean getHasIsReminder(){
return hasIsReminder;
}
public void setHasIsReminder(boolean hasIsReminder){
this.hasIsReminder=hasIsReminder;
}
public void setIsReminder(String isReminder){
this.hasIsReminder=true;
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
private boolean hasReminderType=false;
public boolean getHasReminderType(){
return hasReminderType;
}
public void setHasReminderType(boolean hasReminderType){
this.hasReminderType=hasReminderType;
}
public void setReminderType(String reminderType){
this.hasReminderType=true;
this.reminderType=reminderType;
}
public String getReminderType(){
return reminderType;
}
 
} 