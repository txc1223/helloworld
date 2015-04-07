package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.Friend;

 public  class ModFriendRequest extends Request {
 
private Friend friend;
public void setFriend(Friend friend){
this.friend=friend;
}
public Friend getFriend(){
return friend;
}
 
} 