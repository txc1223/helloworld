package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.ptservice.common.Unit;

import com.beyondbit.smartbox.response.Response;

 public  class QueryAssistUnitsResponse extends Response 
{
 
private Unit[] assistUnit;
public void setAssistUnit(Unit[] assistUnit){
this.assistUnit=assistUnit;
}
public Unit[] getAssistUnit(){
return assistUnit;
}
 
} 