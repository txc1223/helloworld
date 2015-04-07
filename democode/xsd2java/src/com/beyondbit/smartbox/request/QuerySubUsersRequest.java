package com.beyondbit.smartbox.request;
import java.io.Serializable;
 public  class QuerySubUsersRequest extends Request  implements Serializable{
 
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
 
} 