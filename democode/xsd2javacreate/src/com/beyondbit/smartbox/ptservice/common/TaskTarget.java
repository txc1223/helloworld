package com.beyondbit.smartbox.ptservice.common;
import com.beyondbit.smartbox.ptservice.common.File;

 public  class TaskTarget {
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
 private String status;
public void setStatus(String status){
this.status=status;
}
public String getStatus(){
return status;
}
 private String reportStatus;
public void setReportStatus(String reportStatus){
this.reportStatus=reportStatus;
}
public String getReportStatus(){
return reportStatus;
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
 private String description;
public void setDescription(String description){
this.description=description;
}
public String getDescription(){
return description;
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
 private boolean derive;
private boolean hasDerive=false;
public boolean getHasDerive(){
return hasDerive;
}
public void setHasDerive(boolean hasDerive){
this.hasDerive=hasDerive;
}
public void setDerive(boolean derive){
this.hasDerive=true;
this.derive=derive;
}
public boolean getDerive(){
return derive;
}
 private String taskName;
public void setTaskName(String taskName){
this.taskName=taskName;
}
public String getTaskName(){
return taskName;
}
 private String projectName;
public void setProjectName(String projectName){
this.projectName=projectName;
}
public String getProjectName(){
return projectName;
}
 private String manageUnit;
public void setManageUnit(String manageUnit){
this.manageUnit=manageUnit;
}
public String getManageUnit(){
return manageUnit;
}
 private String regionLeader;
public void setRegionLeader(String regionLeader){
this.regionLeader=regionLeader;
}
public String getRegionLeader(){
return regionLeader;
}
 private String assistUnitCode;
public void setAssistUnitCode(String assistUnitCode){
this.assistUnitCode=assistUnitCode;
}
public String getAssistUnitCode(){
return assistUnitCode;
}
 private String assistUnitName;
public void setAssistUnitName(String assistUnitName){
this.assistUnitName=assistUnitName;
}
public String getAssistUnitName(){
return assistUnitName;
}
 private String assistUnitManager;
public void setAssistUnitManager(String assistUnitManager){
this.assistUnitManager=assistUnitManager;
}
public String getAssistUnitManager(){
return assistUnitManager;
}
 private String assistUnitExcutor;
public void setAssistUnitExcutor(String assistUnitExcutor){
this.assistUnitExcutor=assistUnitExcutor;
}
public String getAssistUnitExcutor(){
return assistUnitExcutor;
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
 private String reportDescription;
public void setReportDescription(String reportDescription){
this.reportDescription=reportDescription;
}
public String getReportDescription(){
return reportDescription;
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
 private String remark;
public void setRemark(String remark){
this.remark=remark;
}
public String getRemark(){
return remark;
}
 
private File[] file;
public void setFile(File[] file){
this.file=file;
}
public File[] getFile(){
return file;
}
 private String assessOpinion;
public void setAssessOpinion(String assessOpinion){
this.assessOpinion=assessOpinion;
}
public String getAssessOpinion(){
return assessOpinion;
}
 
} 