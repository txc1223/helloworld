package com.beyondbit.smartbox.response;
 public  class ClCheckPermissionResponse extends Response {
 private boolean hasDept;
public void setHasDept(boolean hasDept){
this.hasDept=hasDept;
}
public boolean getHasDept(){
return hasDept;
}
 private boolean hasUnit;
public void setHasUnit(boolean hasUnit){
this.hasUnit=hasUnit;
}
public boolean getHasUnit(){
return hasUnit;
}
 
} 