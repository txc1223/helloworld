package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.common.ComplexElement;

import com.beyondbit.smartbox.request.Request;

 public  class SubmitRequest extends Request 
{
 private String module;
public void setModule(String module){
this.module=module;
}
public String getModule(){
return module;
}
 private String method;
public void setMethod(String method){
this.method=method;
}
public String getMethod(){
return method;
}
 
private ComplexElement submitItem;
private boolean hasSubmitItem=false;
public boolean getHasSubmitItem(){
return hasSubmitItem;
}
public void setHasSubmitItem(boolean hasSubmitItem){
this.hasSubmitItem=hasSubmitItem;
}
public void setSubmitItem(ComplexElement submitItem){
this.hasSubmitItem=true;
this.submitItem=submitItem;
}
public ComplexElement getSubmitItem(){
return submitItem;
}
 
} 