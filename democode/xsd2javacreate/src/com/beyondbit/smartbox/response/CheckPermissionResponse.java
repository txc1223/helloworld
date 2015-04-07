package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.response.Permission;

 public  class CheckPermissionResponse extends Response {
 
private Permission permission;
public void setPermission(Permission permission){
this.permission=permission;
}
public Permission getPermission(){
return permission;
}
 
} 