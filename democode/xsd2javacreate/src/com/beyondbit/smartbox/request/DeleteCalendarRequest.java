package com.beyondbit.smartbox.request;
 public  class DeleteCalendarRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String itemId;
public void setItemId(String itemId){
this.itemId=itemId;
}
public String getItemId(){
return itemId;
}
 private String calendarType;
public void setCalendarType(String calendarType){
this.calendarType=calendarType;
}
public String getCalendarType(){
return calendarType;
}
 private String instanceType;
public void setInstanceType(String instanceType){
this.instanceType=instanceType;
}
public String getInstanceType(){
return instanceType;
}
 
} 