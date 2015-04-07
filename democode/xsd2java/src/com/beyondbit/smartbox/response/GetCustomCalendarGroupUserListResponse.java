package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.User;

import java.io.Serializable;
 public  class GetCustomCalendarGroupUserListResponse extends Response  implements Serializable{
 
private User[] user;
private boolean hasUser=false;
public boolean getHasUser(){
return hasUser;
}
public void setHasUser(boolean hasUser){
this.hasUser=hasUser;
}
public void setUser(User[] user){
this.hasUser=true;
this.user=user;
}
public User[] getUser(){
return user;
}
 
} 