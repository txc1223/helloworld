package com.beyondbit.smartbox.ptservice.common;
import com.beyondbit.smartbox.ptservice.common.Unit;

import com.beyondbit.smartbox.ptservice.common.MonthStatus;

 public  class Project {
 private String code;
public void setCode(String code){
this.code=code;
}
public String getCode(){
return code;
}
 private String name;
public void setName(String name){
this.name=name;
}
public String getName(){
return name;
}
 private String category;
public void setCategory(String category){
this.category=category;
}
public String getCategory(){
return category;
}
 private String type;
public void setType(String type){
this.type=type;
}
public String getType(){
return type;
}
 private String shortName;
public void setShortName(String shortName){
this.shortName=shortName;
}
public String getShortName(){
return shortName;
}
 private String typeName;
public void setTypeName(String typeName){
this.typeName=typeName;
}
public String getTypeName(){
return typeName;
}
 private String accountabilityUnit;
public void setAccountabilityUnit(String accountabilityUnit){
this.accountabilityUnit=accountabilityUnit;
}
public String getAccountabilityUnit(){
return accountabilityUnit;
}
 
private MonthStatus[] monthStatus;
public void setMonthStatus(MonthStatus[] monthStatus){
this.monthStatus=monthStatus;
}
public MonthStatus[] getMonthStatus(){
return monthStatus;
}
 
private Unit[] assistUnit;
public void setAssistUnit(Unit[] assistUnit){
this.assistUnit=assistUnit;
}
public Unit[] getAssistUnit(){
return assistUnit;
}
 private String isYhwq;
public void setIsYhwq(String isYhwq){
this.isYhwq=isYhwq;
}
public String getIsYhwq(){
return isYhwq;
}
 private String status;
public void setStatus(String status){
this.status=status;
}
public String getStatus(){
return status;
}
 private java.util.Calendar beginTime;
private boolean hasBeginTime=false;
public boolean getHasBeginTime(){
return hasBeginTime;
}
public void setHasBeginTime(boolean hasBeginTime){
this.hasBeginTime=hasBeginTime;
}
public void setBeginTime(java.util.Calendar beginTime){
this.hasBeginTime=true;
this.beginTime=beginTime;
}
public java.util.Calendar getBeginTime(){
return beginTime;
}
 private java.util.Calendar endTime;
private boolean hasEndTime=false;
public boolean getHasEndTime(){
return hasEndTime;
}
public void setHasEndTime(boolean hasEndTime){
this.hasEndTime=hasEndTime;
}
public void setEndTime(java.util.Calendar endTime){
this.hasEndTime=true;
this.endTime=endTime;
}
public java.util.Calendar getEndTime(){
return endTime;
}
 private String regionLeader;
public void setRegionLeader(String regionLeader){
this.regionLeader=regionLeader;
}
public String getRegionLeader(){
return regionLeader;
}
 private String manageUnit;
public void setManageUnit(String manageUnit){
this.manageUnit=manageUnit;
}
public String getManageUnit(){
return manageUnit;
}
 private String manageUnitManager;
public void setManageUnitManager(String manageUnitManager){
this.manageUnitManager=manageUnitManager;
}
public String getManageUnitManager(){
return manageUnitManager;
}
 private String manageUnitLiaison;
public void setManageUnitLiaison(String manageUnitLiaison){
this.manageUnitLiaison=manageUnitLiaison;
}
public String getManageUnitLiaison(){
return manageUnitLiaison;
}
 private String accountabilityUnitManager;
public void setAccountabilityUnitManager(String accountabilityUnitManager){
this.accountabilityUnitManager=accountabilityUnitManager;
}
public String getAccountabilityUnitManager(){
return accountabilityUnitManager;
}
 private String accountabilityUnitLiaison;
public void setAccountabilityUnitLiaison(String accountabilityUnitLiaison){
this.accountabilityUnitLiaison=accountabilityUnitLiaison;
}
public String getAccountabilityUnitLiaison(){
return accountabilityUnitLiaison;
}
 private String assistUnitManagers;
public void setAssistUnitManagers(String assistUnitManagers){
this.assistUnitManagers=assistUnitManagers;
}
public String getAssistUnitManagers(){
return assistUnitManagers;
}
 private String assistUnitExcutors;
public void setAssistUnitExcutors(String assistUnitExcutors){
this.assistUnitExcutors=assistUnitExcutors;
}
public String getAssistUnitExcutors(){
return assistUnitExcutors;
}
 private String description;
public void setDescription(String description){
this.description=description;
}
public String getDescription(){
return description;
}
 private String attachedFiles;
public void setAttachedFiles(String attachedFiles){
this.attachedFiles=attachedFiles;
}
public String getAttachedFiles(){
return attachedFiles;
}
 private String createUserName;
public void setCreateUserName(String createUserName){
this.createUserName=createUserName;
}
public String getCreateUserName(){
return createUserName;
}
 private String updateUserName;
public void setUpdateUserName(String updateUserName){
this.updateUserName=updateUserName;
}
public String getUpdateUserName(){
return updateUserName;
}
 
} 