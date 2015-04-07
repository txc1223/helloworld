package com.beyondbit.smartbox.request;
 public  class CheckPermissionRequest extends Request {
 private String appCode;
public void setAppCode(String appCode){
this.appCode=appCode;
}
public String getAppCode(){
return appCode;
}
 private String[] privilegeCode;
public void setPrivilegeCode(String[] privilegeCode){
this.privilegeCode=privilegeCode;
}
public String[] getPrivilegeCode(){
return privilegeCode;
}
 
} 