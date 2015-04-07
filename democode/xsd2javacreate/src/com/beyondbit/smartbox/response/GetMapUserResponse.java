package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.UserMap;

 public  class GetMapUserResponse extends Response {
 
private UserMap userMap;
public void setUserMap(UserMap userMap){
this.userMap=userMap;
}
public UserMap getUserMap(){
return userMap;
}
 
} 