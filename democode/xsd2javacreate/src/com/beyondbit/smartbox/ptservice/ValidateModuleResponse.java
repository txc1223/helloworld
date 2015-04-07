package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.response.Response;

 public  class ValidateModuleResponse extends Response 
{
 private String[] module;
public void setModule(String[] module){
this.module=module;
}
public String[] getModule(){
return module;
}
 
} 