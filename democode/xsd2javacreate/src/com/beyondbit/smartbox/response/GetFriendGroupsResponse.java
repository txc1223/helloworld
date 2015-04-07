package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.FriendGroupList;

 public  class GetFriendGroupsResponse extends Response {
 
private FriendGroupList friendGroupList;
public void setFriendGroupList(FriendGroupList friendGroupList){
this.friendGroupList=friendGroupList;
}
public FriendGroupList getFriendGroupList(){
return friendGroupList;
}
 
} 