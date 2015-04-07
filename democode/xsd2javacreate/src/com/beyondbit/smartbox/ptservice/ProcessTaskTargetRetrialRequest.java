package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class ProcessTaskTargetRetrialRequest extends Request 
{
 private String taskTargetCode;
public void setTaskTargetCode(String taskTargetCode){
this.taskTargetCode=taskTargetCode;
}
public String getTaskTargetCode(){
return taskTargetCode;
}
 private boolean accept;
public void setAccept(boolean accept){
this.accept=accept;
}
public boolean getAccept(){
return accept;
}
 private String acceptContent;
public void setAcceptContent(String acceptContent){
this.acceptContent=acceptContent;
}
public String getAcceptContent(){
return acceptContent;
}
 private java.util.Calendar endTime;
private boolean hasEndTime=false;
public boolean getHasEndTime(){
return hasEndTime;
}
public void setHasEndTime(boolean hasEndTime){
this.hasEndTime=hasEndTime;
}
public void setEndTime(java.util.Calendar endTime){
this.hasEndTime=true;
this.endTime=endTime;
}
public java.util.Calendar getEndTime(){
return endTime;
}
 private String method;
public void setMethod(String method){
this.method=method;
}
public String getMethod(){
return method;
}
 
} 