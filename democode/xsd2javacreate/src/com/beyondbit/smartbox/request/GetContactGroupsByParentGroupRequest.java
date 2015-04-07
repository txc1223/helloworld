package com.beyondbit.smartbox.request;
 public  class GetContactGroupsByParentGroupRequest extends Request {
 private String parentGroupCode;
public void setParentGroupCode(String parentGroupCode){
this.parentGroupCode=parentGroupCode;
}
public String getParentGroupCode(){
return parentGroupCode;
}
 
} 