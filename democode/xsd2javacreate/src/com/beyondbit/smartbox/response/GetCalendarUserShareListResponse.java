package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.UserShare;

 public  class GetCalendarUserShareListResponse extends Response {
 
private UserShare[] userShare;
public void setUserShare(UserShare[] userShare){
this.userShare=userShare;
}
public UserShare[] getUserShare(){
return userShare;
}
 
} 