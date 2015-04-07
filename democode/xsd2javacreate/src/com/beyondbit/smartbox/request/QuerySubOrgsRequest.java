package com.beyondbit.smartbox.request;
 public  class QuerySubOrgsRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String parentOrgId;
public void setParentOrgId(String parentOrgId){
this.parentOrgId=parentOrgId;
}
public String getParentOrgId(){
return parentOrgId;
}
 
} 