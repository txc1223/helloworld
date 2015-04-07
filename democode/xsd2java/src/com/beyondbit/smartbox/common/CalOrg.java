package com.beyondbit.smartbox.common;
import java.io.Serializable;
 public  class CalOrg  implements Serializable{
 
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
 private String orgName;
private boolean hasOrgName=false;
public boolean getHasOrgName(){
return hasOrgName;
}
public void setHasOrgName(boolean hasOrgName){
this.hasOrgName=hasOrgName;
}
public void setOrgName(String orgName){
this.hasOrgName=true;
this.orgName=orgName;
}
public String getOrgName(){
return orgName;
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