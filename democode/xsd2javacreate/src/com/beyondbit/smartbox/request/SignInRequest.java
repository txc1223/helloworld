package com.beyondbit.smartbox.request;
 public  class SignInRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String userPwd;
public void setUserPwd(String userPwd){
this.userPwd=userPwd;
}
public String getUserPwd(){
return userPwd;
}
 private String client;
public void setClient(String client){
this.client=client;
}
public String getClient(){
return client;
}
 private String deviceId;
public void setDeviceId(String deviceId){
this.deviceId=deviceId;
}
public String getDeviceId(){
return deviceId;
}
 
} 