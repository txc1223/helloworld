package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class ValidateModuleRequest extends Request 
{
 private String[] module;
public void setModule(String[] module){
this.module=module;
}
public String[] getModule(){
return module;
}
 
} 