package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.UserStatusList;

 public  class GetUserStatusResponse extends Response {
 
private UserStatusList userStatusList;
public void setUserStatusList(UserStatusList userStatusList){
this.userStatusList=userStatusList;
}
public UserStatusList getUserStatusList(){
return userStatusList;
}
 
} 