package com.beyondbit.smartbox.request;
 public  class ChangeUserInfoRequest extends Request {
 private String userMobilePhone;
public void setUserMobilePhone(String userMobilePhone){
this.userMobilePhone=userMobilePhone;
}
public String getUserMobilePhone(){
return userMobilePhone;
}
 private String userOfficePhone;
public void setUserOfficePhone(String userOfficePhone){
this.userOfficePhone=userOfficePhone;
}
public String getUserOfficePhone(){
return userOfficePhone;
}
 private String userFax;
public void setUserFax(String userFax){
this.userFax=userFax;
}
public String getUserFax(){
return userFax;
}
 private String userExtPhone;
public void setUserExtPhone(String userExtPhone){
this.userExtPhone=userExtPhone;
}
public String getUserExtPhone(){
return userExtPhone;
}
 private String userOfficeRoom;
public void setUserOfficeRoom(String userOfficeRoom){
this.userOfficeRoom=userOfficeRoom;
}
public String getUserOfficeRoom(){
return userOfficeRoom;
}
 
} 