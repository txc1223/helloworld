package com.beyondbit.smartbox.request;
import java.io.Serializable;
 public  class DeleteCalendarRequest extends Request  implements Serializable{
 
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
 private String itemId;
private boolean hasItemId=false;
public boolean getHasItemId(){
return hasItemId;
}
public void setHasItemId(boolean hasItemId){
this.hasItemId=hasItemId;
}
public void setItemId(String itemId){
this.hasItemId=true;
this.itemId=itemId;
}
public String getItemId(){
return itemId;
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
 private String instanceType;
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
 
} 