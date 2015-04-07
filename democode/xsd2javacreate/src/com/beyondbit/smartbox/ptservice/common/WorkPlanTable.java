package com.beyondbit.smartbox.ptservice.common;
import com.beyondbit.smartbox.ptservice.common.WorkPlanList;

 public  class WorkPlanTable {
 private String unitCode;
public void setUnitCode(String unitCode){
this.unitCode=unitCode;
}
public String getUnitCode(){
return unitCode;
}
 private String unitName;
public void setUnitName(String unitName){
this.unitName=unitName;
}
public String getUnitName(){
return unitName;
}
 private String leaderCode;
public void setLeaderCode(String leaderCode){
this.leaderCode=leaderCode;
}
public String getLeaderCode(){
return leaderCode;
}
 private String leaderName;
public void setLeaderName(String leaderName){
this.leaderName=leaderName;
}
public String getLeaderName(){
return leaderName;
}
 
private WorkPlanList[] workPlanList;
public void setWorkPlanList(WorkPlanList[] workPlanList){
this.workPlanList=workPlanList;
}
public WorkPlanList[] getWorkPlanList(){
return workPlanList;
}
 
} 