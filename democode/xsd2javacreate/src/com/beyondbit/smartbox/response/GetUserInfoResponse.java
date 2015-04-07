package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.UserInfo;

 public  class GetUserInfoResponse extends Response {
 
private UserInfo userInfo;
public void setUserInfo(UserInfo userInfo){
this.userInfo=userInfo;
}
public UserInfo getUserInfo(){
return userInfo;
}
 
} 