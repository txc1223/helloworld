package com.beyondbit.smartbox.request;
import java.io.Serializable;
 public  class QueryCalendarsRequest extends Request  implements Serializable{
 
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
 private java.util.Calendar viewStartTime;
private boolean hasViewStartTime=false;
public boolean getHasViewStartTime(){
return hasViewStartTime;
}
public void setHasViewStartTime(boolean hasViewStartTime){
this.hasViewStartTime=hasViewStartTime;
}
public void setViewStartTime(java.util.Calendar viewStartTime){
this.hasViewStartTime=true;
this.viewStartTime=viewStartTime;
}
public java.util.Calendar getViewStartTime(){
return viewStartTime;
}
 private java.util.Calendar viewEndTime;
private boolean hasViewEndTime=false;
public boolean getHasViewEndTime(){
return hasViewEndTime;
}
public void setHasViewEndTime(boolean hasViewEndTime){
this.hasViewEndTime=hasViewEndTime;
}
public void setViewEndTime(java.util.Calendar viewEndTime){
this.hasViewEndTime=true;
this.viewEndTime=viewEndTime;
}
public java.util.Calendar getViewEndTime(){
return viewEndTime;
}
 private String subject;
private boolean hasSubject=false;
public boolean getHasSubject(){
return hasSubject;
}
public void setHasSubject(boolean hasSubject){
this.hasSubject=hasSubject;
}
public void setSubject(String subject){
this.hasSubject=true;
this.subject=subject;
}
public String getSubject(){
return subject;
}
 private int isPrecise;
private boolean hasIsPrecise=false;
public boolean getHasIsPrecise(){
return hasIsPrecise;
}
public void setHasIsPrecise(boolean hasIsPrecise){
this.hasIsPrecise=hasIsPrecise;
}
public void setIsPrecise(int isPrecise){
this.hasIsPrecise=true;
this.isPrecise=isPrecise;
}
public int getIsPrecise(){
return isPrecise;
}
 private String calendarType;
private boolean hasCalendarType=false;
public boolean getHasCalendarType(){
return hasCalendarType;
}
public void setHasCalendarType(boolean hasCalendarType){
this.hasCalendarType=hasCalendarType;
}
public void setCalendarType(String calendarType){
this.hasCalendarType=true;
this.calendarType=calendarType;
}
public String getCalendarType(){
return calendarType;
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
 private int pageSize;
private boolean hasPageSize=false;
public boolean getHasPageSize(){
return hasPageSize;
}
public void setHasPageSize(boolean hasPageSize){
this.hasPageSize=hasPageSize;
}
public void setPageSize(int pageSize){
this.hasPageSize=true;
this.pageSize=pageSize;
}
public int getPageSize(){
return pageSize;
}
 private int pageIndex;
private boolean hasPageIndex=false;
public boolean getHasPageIndex(){
return hasPageIndex;
}
public void setHasPageIndex(boolean hasPageIndex){
this.hasPageIndex=hasPageIndex;
}
public void setPageIndex(int pageIndex){
this.hasPageIndex=true;
this.pageIndex=pageIndex;
}
public int getPageIndex(){
return pageIndex;
}
 
} 