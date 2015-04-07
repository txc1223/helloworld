package com.beyondbit.smartbox.request;
 public  class ViewCallBoardRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String iD;
public void setID(String iD){
this.iD=iD;
}
public String getID(){
return iD;
}
 private String iP;
public void setIP(String iP){
this.iP=iP;
}
public String getIP(){
return iP;
}
 
} 