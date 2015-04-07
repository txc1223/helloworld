package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class QueryProjectTaskListRequest extends Request 
{
 private String projectCode;
public void setProjectCode(String projectCode){
this.projectCode=projectCode;
}
public String getProjectCode(){
return projectCode;
}
 
} 