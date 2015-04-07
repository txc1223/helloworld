package com.beyondbit.smartbox.response;
import java.io.Serializable;
 public  class ClCheckPermissionResponse extends Response  implements Serializable{
 
private boolean hasDept;
private boolean hasHasDept=false;
public boolean getHasHasDept(){
return hasHasDept;
}
public void setHasHasDept(boolean hasHasDept){
this.hasHasDept=hasHasDept;
}
public void setHasDept(boolean hasDept){
this.hasHasDept=true;
this.hasDept=hasDept;
}
public boolean getHasDept(){
return hasDept;
}
 private boolean hasUnit;
private boolean hasHasUnit=false;
public boolean getHasHasUnit(){
return hasHasUnit;
}
public void setHasHasUnit(boolean hasHasUnit){
this.hasHasUnit=hasHasUnit;
}
public void setHasUnit(boolean hasUnit){
this.hasHasUnit=true;
this.hasUnit=hasUnit;
}
public boolean getHasUnit(){
return hasUnit;
}
 
} 