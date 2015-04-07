package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class QuerySubmitTaskTargetRequest extends Request 
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
 private String type;
public void setType(String type){
this.type=type;
}
public String getType(){
return type;
}
 
} 