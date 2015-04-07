package com.beyondbit.smartbox.request;
 public  class ChangePwdRequest extends Request {
 private String newPwd;
public void setNewPwd(String newPwd){
this.newPwd=newPwd;
}
public String getNewPwd(){
return newPwd;
}
 private String oldPwd;
public void setOldPwd(String oldPwd){
this.oldPwd=oldPwd;
}
public String getOldPwd(){
return oldPwd;
}
 
} 