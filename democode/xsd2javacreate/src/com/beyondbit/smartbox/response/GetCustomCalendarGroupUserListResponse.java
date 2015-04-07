package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.User;

 public  class GetCustomCalendarGroupUserListResponse extends Response {
 
private User[] user;
public void setUser(User[] user){
this.user=user;
}
public User[] getUser(){
return user;
}
 
} 