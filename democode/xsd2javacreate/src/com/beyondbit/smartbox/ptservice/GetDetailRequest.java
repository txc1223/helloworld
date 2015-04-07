package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.common.ComplexElement;

import com.beyondbit.smartbox.request.Request;

 public  class GetDetailRequest extends Request 
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
 private String id;
public void setId(String id){
this.id=id;
}
public String getId(){
return id;
}
 
private ComplexElement searchCondition;
private boolean hasSearchCondition=false;
public boolean getHasSearchCondition(){
return hasSearchCondition;
}
public void setHasSearchCondition(boolean hasSearchCondition){
this.hasSearchCondition=hasSearchCondition;
}
public void setSearchCondition(ComplexElement searchCondition){
this.hasSearchCondition=true;
this.searchCondition=searchCondition;
}
public ComplexElement getSearchCondition(){
return searchCondition;
}
 
} 