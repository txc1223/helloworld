package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class AcceptTaskTargetRequest extends Request 
{
 private String taskTargetCode;
public void setTaskTargetCode(String taskTargetCode){
this.taskTargetCode=taskTargetCode;
}
public String getTaskTargetCode(){
return taskTargetCode;
}
 private String remark;
public void setRemark(String remark){
this.remark=remark;
}
public String getRemark(){
return remark;
}
 private boolean action;
public void setAction(boolean action){
this.action=action;
}
public boolean getAction(){
return action;
}
 
} 