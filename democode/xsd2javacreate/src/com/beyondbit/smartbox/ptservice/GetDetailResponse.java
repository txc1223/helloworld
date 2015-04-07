package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.ptservice.Opinion;

import com.beyondbit.smartbox.common.ComplexElement;

import com.beyondbit.smartbox.response.Response;

 public  class GetDetailResponse extends Response 
{
 
private ComplexElement result;
private boolean hasResult=false;
public boolean getHasResult(){
return hasResult;
}
public void setHasResult(boolean hasResult){
this.hasResult=hasResult;
}
public void setResult(ComplexElement result){
this.hasResult=true;
this.result=result;
}
public ComplexElement getResult(){
return result;
}
 
private Opinion[] opinion;
public void setOpinion(Opinion[] opinion){
this.opinion=opinion;
}
public Opinion[] getOpinion(){
return opinion;
}
 
} 