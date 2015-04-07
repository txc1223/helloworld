package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class GetWorkPlanRequest extends Request 
{
 private String workPlanID;
public void setWorkPlanID(String workPlanID){
this.workPlanID=workPlanID;
}
public String getWorkPlanID(){
return workPlanID;
}
 
} 