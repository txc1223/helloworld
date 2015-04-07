package com.beyondbit.smartbox.request;
 public  class GetFriendByUidRequest extends Request {
 private String friendUid;
public void setFriendUid(String friendUid){
this.friendUid=friendUid;
}
public String getFriendUid(){
return friendUid;
}
 
} 