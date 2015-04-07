package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.Friend;

 public  class GetFriendByUidResponse extends Response {
 
private Friend friend;
public void setFriend(Friend friend){
this.friend=friend;
}
public Friend getFriend(){
return friend;
}
 
} 