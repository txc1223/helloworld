package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.FriendList;

 public  class AddFriendsRequest extends Request {
 
private FriendList friendList;
public void setFriendList(FriendList friendList){
this.friendList=friendList;
}
public FriendList getFriendList(){
return friendList;
}
 private String groupId;
public void setGroupId(String groupId){
this.groupId=groupId;
}
public String getGroupId(){
return groupId;
}
 
} 