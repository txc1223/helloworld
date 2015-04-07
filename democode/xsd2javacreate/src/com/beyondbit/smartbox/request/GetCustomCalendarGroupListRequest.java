package com.beyondbit.smartbox.request;
 public  class GetCustomCalendarGroupListRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String groupId;
public void setGroupId(String groupId){
this.groupId=groupId;
}
public String getGroupId(){
return groupId;
}
 
} 