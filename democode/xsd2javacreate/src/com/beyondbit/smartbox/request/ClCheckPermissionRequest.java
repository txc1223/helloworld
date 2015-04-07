package com.beyondbit.smartbox.request;
 public  class ClCheckPermissionRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 
} 