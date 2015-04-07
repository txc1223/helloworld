package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.FriendList;

 public  class GetAllFriendsResponse extends Response {
 
private FriendList friendList;
public void setFriendList(FriendList friendList){
this.friendList=friendList;
}
public FriendList getFriendList(){
return friendList;
}
 
} 