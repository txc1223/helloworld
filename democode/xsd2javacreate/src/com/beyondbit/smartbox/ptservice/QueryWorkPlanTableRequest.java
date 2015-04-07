package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class QueryWorkPlanTableRequest extends Request 
{
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
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