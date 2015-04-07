package com.beyondbit.smartbox.response;
import java.io.Serializable;
 public  class GetUserDeptAndUnitResponse extends Response  implements Serializable{
 
private String deptId;
private boolean hasDeptId=false;
public boolean getHasDeptId(){
return hasDeptId;
}
public void setHasDeptId(boolean hasDeptId){
this.hasDeptId=hasDeptId;
}
public void setDeptId(String deptId){
this.hasDeptId=true;
this.deptId=deptId;
}
public String getDeptId(){
return deptId;
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
 private String unitId;
private boolean hasUnitId=false;
public boolean getHasUnitId(){
return hasUnitId;
}
public void setHasUnitId(boolean hasUnitId){
this.hasUnitId=hasUnitId;
}
public void setUnitId(String unitId){
this.hasUnitId=true;
this.unitId=unitId;
}
public String getUnitId(){
return unitId;
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