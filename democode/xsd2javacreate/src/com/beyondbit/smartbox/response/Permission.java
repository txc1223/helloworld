package com.beyondbit.smartbox.response;
 public  class Permission {
 private String privilegeCode;
public void setPrivilegeCode(String privilegeCode){
this.privilegeCode=privilegeCode;
}
public String getPrivilegeCode(){
return privilegeCode;
}
 private boolean accessable;
public void setAccessable(boolean accessable){
this.accessable=accessable;
}
public boolean getAccessable(){
return accessable;
}
 
} 