package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class AddProjectRemarkRequest extends Request 
{
 private String projectCode;
public void setProjectCode(String projectCode){
this.projectCode=projectCode;
}
public String getProjectCode(){
return projectCode;
}
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String content;
public void setContent(String content){
this.content=content;
}
public String getContent(){
return content;
}
 
} 