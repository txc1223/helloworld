package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class QueryAssistUnitsRequest extends Request 
{
 private String projectCode;
public void setProjectCode(String projectCode){
this.projectCode=projectCode;
}
public String getProjectCode(){
return projectCode;
}
 private String assistUnitCode;
public void setAssistUnitCode(String assistUnitCode){
this.assistUnitCode=assistUnitCode;
}
public String getAssistUnitCode(){
return assistUnitCode;
}
 
} 