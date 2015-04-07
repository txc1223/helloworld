package com.beyondbit.smartbox.common;
import java.io.Serializable;
 public  class User  implements Serializable{
 
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
 private String userFullName;
private boolean hasUserFullName=false;
public boolean getHasUserFullName(){
return hasUserFullName;
}
public void setHasUserFullName(boolean hasUserFullName){
this.hasUserFullName=hasUserFullName;
}
public void setUserFullName(String userFullName){
this.hasUserFullName=true;
this.userFullName=userFullName;
}
public String getUserFullName(){
return userFullName;
}
 private String deptCode;
private boolean hasDeptCode=false;
public boolean getHasDeptCode(){
return hasDeptCode;
}
public void setHasDeptCode(boolean hasDeptCode){
this.hasDeptCode=hasDeptCode;
}
public void setDeptCode(String deptCode){
this.hasDeptCode=true;
this.deptCode=deptCode;
}
public String getDeptCode(){
return deptCode;
}
 private String deptName;
private boolean hasDeptName=false;
public boolean getHasDeptName(){
return hasDeptName;
}
public void setHasDeptName(boolean hasDeptName){
this.hasDeptName=hasDeptName;
}
public void setDeptName(String deptName){
this.hasDeptName=true;
this.deptName=deptName;
}
public String getDeptName(){
return deptName;
}
 private String uintCode;
private boolean hasUintCode=false;
public boolean getHasUintCode(){
return hasUintCode;
}
public void setHasUintCode(boolean hasUintCode){
this.hasUintCode=hasUintCode;
}
public void setUintCode(String uintCode){
this.hasUintCode=true;
this.uintCode=uintCode;
}
public String getUintCode(){
return uintCode;
}
 private String unitName;
private boolean hasUnitName=false;
public boolean getHasUnitName(){
return hasUnitName;
}
public void setHasUnitName(boolean hasUnitName){
this.hasUnitName=hasUnitName;
}
public void setUnitName(String unitName){
this.hasUnitName=true;
this.unitName=unitName;
}
public String getUnitName(){
return unitName;
}
 
} 