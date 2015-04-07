package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class DeleteWorkPlanRequest extends Request 
{
 private String workPlanId;
public void setWorkPlanId(String workPlanId){
this.workPlanId=workPlanId;
}
public String getWorkPlanId(){
return workPlanId;
}
 
} 