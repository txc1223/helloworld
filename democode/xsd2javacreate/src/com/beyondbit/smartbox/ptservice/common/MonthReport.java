package com.beyondbit.smartbox.ptservice.common;
import com.beyondbit.smartbox.ptservice.common.TaskTarget;

 public  class MonthReport {
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
 private int month;
private boolean hasMonth=false;
public boolean getHasMonth(){
return hasMonth;
}
public void setHasMonth(boolean hasMonth){
this.hasMonth=hasMonth;
}
public void setMonth(int month){
this.hasMonth=true;
this.month=month;
}
public int getMonth(){
return month;
}
 private String status;
public void setStatus(String status){
this.status=status;
}
public String getStatus(){
return status;
}
 private String projectName;
public void setProjectName(String projectName){
this.projectName=projectName;
}
public String getProjectName(){
return projectName;
}
 private String projectShortName;
public void setProjectShortName(String projectShortName){
this.projectShortName=projectShortName;
}
public String getProjectShortName(){
return projectShortName;
}
 private String projectType;
public void setProjectType(String projectType){
this.projectType=projectType;
}
public String getProjectType(){
return projectType;
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
 private String accountabilityUnit;
public void setAccountabilityUnit(String accountabilityUnit){
this.accountabilityUnit=accountabilityUnit;
}
public String getAccountabilityUnit(){
return accountabilityUnit;
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
 private String unFinishedReason;
public void setUnFinishedReason(String unFinishedReason){
this.unFinishedReason=unFinishedReason;
}
public String getUnFinishedReason(){
return unFinishedReason;
}
 private String suggest;
public void setSuggest(String suggest){
this.suggest=suggest;
}
public String getSuggest(){
return suggest;
}
 private String reportDescription;
public void setReportDescription(String reportDescription){
this.reportDescription=reportDescription;
}
public String getReportDescription(){
return reportDescription;
}
 private String remark;
public void setRemark(String remark){
this.remark=remark;
}
public String getRemark(){
return remark;
}
 private String description;
public void setDescription(String description){
this.description=description;
}
public String getDescription(){
return description;
}
 private String stage;
public void setStage(String stage){
this.stage=stage;
}
public String getStage(){
return stage;
}
 private String publishUnit;
public void setPublishUnit(String publishUnit){
this.publishUnit=publishUnit;
}
public String getPublishUnit(){
return publishUnit;
}
 private String publisher;
public void setPublisher(String publisher){
this.publisher=publisher;
}
public String getPublisher(){
return publisher;
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
 
private TaskTarget[] taskTarget;
public void setTaskTarget(TaskTarget[] taskTarget){
this.taskTarget=taskTarget;
}
public TaskTarget[] getTaskTarget(){
return taskTarget;
}
 private String assessOpinion;
public void setAssessOpinion(String assessOpinion){
this.assessOpinion=assessOpinion;
}
public String getAssessOpinion(){
return assessOpinion;
}
 
} 