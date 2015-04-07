package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.GroupType;

 public  class FriendGroup {
 private String friendGroupId;
public void setFriendGroupId(String friendGroupId){
this.friendGroupId=friendGroupId;
}
public String getFriendGroupId(){
return friendGroupId;
}
 private String groupName;
public void setGroupName(String groupName){
this.groupName=groupName;
}
public String getGroupName(){
return groupName;
}
 private String ownerUid;
public void setOwnerUid(String ownerUid){
this.ownerUid=ownerUid;
}
public String getOwnerUid(){
return ownerUid;
}
 
private GroupType groupType;
public void setGroupType(GroupType groupType){
this.groupType=groupType;
}
public GroupType getGroupType(){
return groupType;
}
 private int sequence;
public void setSequence(int sequence){
this.sequence=sequence;
}
public int getSequence(){
return sequence;
}
 
} 