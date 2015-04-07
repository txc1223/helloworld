package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.response.Response;

 public  class QueryUserRolesResponse extends Response 
{
 private String[] roleCode;
public void setRoleCode(String[] roleCode){
this.roleCode=roleCode;
}
public String[] getRoleCode(){
return roleCode;
}
 
} 