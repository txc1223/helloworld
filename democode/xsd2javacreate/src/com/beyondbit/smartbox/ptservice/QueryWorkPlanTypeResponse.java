package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.ptservice.common.WorkPlanType;

import com.beyondbit.smartbox.response.Response;

 public  class QueryWorkPlanTypeResponse extends Response 
{
 
private WorkPlanType[] workPlanType;
public void setWorkPlanType(WorkPlanType[] workPlanType){
this.workPlanType=workPlanType;
}
public WorkPlanType[] getWorkPlanType(){
return workPlanType;
}
 
} 