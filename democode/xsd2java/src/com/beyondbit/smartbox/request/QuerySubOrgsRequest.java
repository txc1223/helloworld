package com.beyondbit.smartbox.request;
import java.io.Serializable;
 public  class QuerySubOrgsRequest extends Request  implements Serializable{
 
private String userUid;
private boolean hasUserUid=false;
public boolean getHasUserUid(){
return hasUserUid;
}
public void setHasUserUid(boolean hasUserUid){
this.hasUserUid=hasUserUid;
}
public void setUserUid(String userUid){
this.hasUserUid=true;
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String parentOrgId;
private boolean hasParentOrgId=false;
public boolean getHasParentOrgId(){
return hasParentOrgId;
}
public void setHasParentOrgId(boolean hasParentOrgId){
this.hasParentOrgId=hasParentOrgId;
}
public void setParentOrgId(String parentOrgId){
this.hasParentOrgId=true;
this.parentOrgId=parentOrgId;
}
public String getParentOrgId(){
return parentOrgId;
}
 
} 