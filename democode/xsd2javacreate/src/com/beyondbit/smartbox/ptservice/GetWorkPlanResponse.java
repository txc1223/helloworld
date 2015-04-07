package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.ptservice.common.WorkPlan;

import com.beyondbit.smartbox.response.Response;

 public  class GetWorkPlanResponse extends Response 
{
 
private WorkPlan workPlan;
public void setWorkPlan(WorkPlan workPlan){
this.workPlan=workPlan;
}
public WorkPlan getWorkPlan(){
return workPlan;
}
 
} 