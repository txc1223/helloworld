package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.StatusType;

 public  class UserStatus {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 
private StatusType status;
public void setStatus(StatusType status){
this.status=status;
}
public StatusType getStatus(){
return status;
}
 private String description;
public void setDescription(String description){
this.description=description;
}
public String getDescription(){
return description;
}
 
} 