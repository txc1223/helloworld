package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.FriendUidList;

 public  class MoveFriendsToGroupRequest extends Request {
 
private FriendUidList friendUidList;
public void setFriendUidList(FriendUidList friendUidList){
this.friendUidList=friendUidList;
}
public FriendUidList getFriendUidList(){
return friendUidList;
}
 private String groupId;
public void setGroupId(String groupId){
this.groupId=groupId;
}
public String getGroupId(){
return groupId;
}
 
} 