package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class QueryUnAcceptTaskTargetRequest extends Request 
{
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String projectShortName;
public void setProjectShortName(String projectShortName){
this.projectShortName=projectShortName;
}
public String getProjectShortName(){
return projectShortName;
}
 
} 