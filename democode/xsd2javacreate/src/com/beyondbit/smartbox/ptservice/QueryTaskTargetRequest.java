package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class QueryTaskTargetRequest extends Request 
{
 private String taskCode;
public void setTaskCode(String taskCode){
this.taskCode=taskCode;
}
public String getTaskCode(){
return taskCode;
}
 
} 