package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class GetTaskTargetRequest extends Request 
{
 private String taskTargetCode;
public void setTaskTargetCode(String taskTargetCode){
this.taskTargetCode=taskTargetCode;
}
public String getTaskTargetCode(){
return taskTargetCode;
}
 
} 