package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.FriendGroup;

 public  class ModFriendGroupRequest extends Request {
 
private FriendGroup friendGroup;
public void setFriendGroup(FriendGroup friendGroup){
this.friendGroup=friendGroup;
}
public FriendGroup getFriendGroup(){
return friendGroup;
}
 
} 