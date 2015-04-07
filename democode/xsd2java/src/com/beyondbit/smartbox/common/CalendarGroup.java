package com.beyondbit.smartbox.common;
import java.io.Serializable;
 public  class CalendarGroup  implements Serializable{
 
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
 private String groupName;
private boolean hasGroupName=false;
public boolean getHasGroupName(){
return hasGroupName;
}
public void setHasGroupName(boolean hasGroupName){
this.hasGroupName=hasGroupName;
}
public void setGroupName(String groupName){
this.hasGroupName=true;
this.groupName=groupName;
}
public String getGroupName(){
return groupName;
}
 
} 