package com.beyondbit.smartbox.request;
import java.io.Serializable;
 public  class QueryCalendarsByUserUIdsRequest extends Request  implements Serializable{
 
private String userUids;
private boolean hasUserUids=false;
public boolean getHasUserUids(){
return hasUserUids;
}
public void setHasUserUids(boolean hasUserUids){
this.hasUserUids=hasUserUids;
}
public void setUserUids(String userUids){
this.hasUserUids=true;
this.userUids=userUids;
}
public String getUserUids(){
return userUids;
}
 private java.util.Calendar viewStartTime;
private boolean hasViewStartTime=false;
public boolean getHasViewStartTime(){
return hasViewStartTime;
}
public void setHasViewStartTime(boolean hasViewStartTime){
this.hasViewStartTime=hasViewStartTime;
}
public void setViewStartTime(java.util.Calendar viewStartTime){
this.hasViewStartTime=true;
this.viewStartTime=viewStartTime;
}
public java.util.Calendar getViewStartTime(){
return viewStartTime;
}
 private java.util.Calendar viewEndTime;
private boolean hasViewEndTime=false;
public boolean getHasViewEndTime(){
return hasViewEndTime;
}
public void setHasViewEndTime(boolean hasViewEndTime){
this.hasViewEndTime=hasViewEndTime;
}
public void setViewEndTime(java.util.Calendar viewEndTime){
this.hasViewEndTime=true;
this.viewEndTime=viewEndTime;
}
public java.util.Calendar getViewEndTime(){
return viewEndTime;
}
 
} 