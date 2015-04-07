package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.FriendUidList;

 public  class RemoveFriendsRequest extends Request {
 
private FriendUidList friendUidList;
public void setFriendUidList(FriendUidList friendUidList){
this.friendUidList=friendUidList;
}
public FriendUidList getFriendUidList(){
return friendUidList;
}
 
} 