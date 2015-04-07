package com.beyondbit.smartbox.response;
 public  class GetUserDeptAndUnitResponse extends Response {
 private String deptId;
public void setDeptId(String deptId){
this.deptId=deptId;
}
public String getDeptId(){
return deptId;
}
 private String deptName;
public void setDeptName(String deptName){
this.deptName=deptName;
}
public String getDeptName(){
return deptName;
}
 private String unitId;
public void setUnitId(String unitId){
this.unitId=unitId;
}
public String getUnitId(){
return unitId;
}
 private String unitName;
public void setUnitName(String unitName){
this.unitName=unitName;
}
public String getUnitName(){
return unitName;
}
 
} 