package com.beyondbit.smartbox.common;
import java.io.Serializable;
 public  class CalUser  implements Serializable{
 
private String orgId;
private boolean hasOrgId=false;
public boolean getHasOrgId(){
return hasOrgId;
}
public void setHasOrgId(boolean hasOrgId){
this.hasOrgId=hasOrgId;
}
public void setOrgId(String orgId){
this.hasOrgId=true;
this.orgId=orgId;
}
public String getOrgId(){
return orgId;
}
 private String userId;
private boolean hasUserId=false;
public boolean getHasUserId(){
return hasUserId;
}
public void setHasUserId(boolean hasUserId){
this.hasUserId=hasUserId;
}
public void setUserId(String userId){
this.hasUserId=true;
this.userId=userId;
}
public String getUserId(){
return userId;
}
 private String userName;
private boolean hasUserName=false;
public boolean getHasUserName(){
return hasUserName;
}
public void setHasUserName(boolean hasUserName){
this.hasUserName=hasUserName;
}
public void setUserName(String userName){
this.hasUserName=true;
this.userName=userName;
}
public String getUserName(){
return userName;
}
 private int sequence;
private boolean hasSequence=false;
public boolean getHasSequence(){
return hasSequence;
}
public void setHasSequence(boolean hasSequence){
this.hasSequence=hasSequence;
}
public void setSequence(int sequence){
this.hasSequence=true;
this.sequence=sequence;
}
public int getSequence(){
return sequence;
}
 
} 