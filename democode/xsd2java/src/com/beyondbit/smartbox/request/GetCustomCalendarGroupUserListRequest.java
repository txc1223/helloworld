package com.beyondbit.smartbox.request;
import java.io.Serializable;
 public  class GetCustomCalendarGroupUserListRequest extends Request  implements Serializable{
 
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