package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.ptservice.common.WorkPlanTable;

import com.beyondbit.smartbox.response.Response;

 public  class QueryWorkPlanTableResponse extends Response 
{
 
private WorkPlanTable[] workPlanTable;
public void setWorkPlanTable(WorkPlanTable[] workPlanTable){
this.workPlanTable=workPlanTable;
}
public WorkPlanTable[] getWorkPlanTable(){
return workPlanTable;
}
 
} 