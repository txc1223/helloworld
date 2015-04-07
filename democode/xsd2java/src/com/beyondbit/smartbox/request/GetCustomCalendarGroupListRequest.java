package com.beyondbit.smartbox.request;
import java.io.Serializable;
 public  class GetCustomCalendarGroupListRequest extends Request  implements Serializable{
 
private String userUid;
private boolean hasUserUid=false;
public boolean getHasUserUid(){
return hasUserUid;
}
public void setHasUserUid(boolean hasUserUid){
this.hasUserUid=hasUserUid;
}
public void setUserUid(String userUid){
this.hasUserUid=true;
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String groupId;
private boolean hasGroupId=false;
public boolean getHasGroupId(){
return hasGroupId;
}
public void setHasGroupId(boolean hasGroupId){
this.hasGroupId=hasGroupId;
}
public void setGroupId(String groupId){
this.hasGroupId=true;
this.groupId=groupId;
}
public String getGroupId(){
return groupId;
}
 
} 