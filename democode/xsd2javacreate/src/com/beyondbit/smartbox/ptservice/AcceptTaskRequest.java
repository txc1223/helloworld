package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class AcceptTaskRequest extends Request 
{
 private String taskCode;
public void setTaskCode(String taskCode){
this.taskCode=taskCode;
}
public String getTaskCode(){
return taskCode;
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