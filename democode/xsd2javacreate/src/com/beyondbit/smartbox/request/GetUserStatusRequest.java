package com.beyondbit.smartbox.request;
 public  class GetUserStatusRequest extends Request {
 private String[] userUid;
public void setUserUid(String[] userUid){
this.userUid=userUid;
}
public String[] getUserUid(){
return userUid;
}
 
} 