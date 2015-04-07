package com.beyondbit.smartbox.request;
 public  class GetCalendarUserShareListRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 
} 