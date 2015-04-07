package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.FriendInviteType;

 public  class FriendInviteRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 
private FriendInviteType type;
public void setType(FriendInviteType type){
this.type=type;
}
public FriendInviteType getType(){
return type;
}
 private String message;
public void setMessage(String message){
this.message=message;
}
public String getMessage(){
return message;
}
 
} 