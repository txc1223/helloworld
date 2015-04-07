package com.beyondbit.smartbox.request;
 public  class GetUsingIconRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String iconCode;
public void setIconCode(String iconCode){
this.iconCode=iconCode;
}
public String getIconCode(){
return iconCode;
}
 
} 