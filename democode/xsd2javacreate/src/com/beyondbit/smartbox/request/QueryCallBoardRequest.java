package com.beyondbit.smartbox.request;
 public  class QueryCallBoardRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String type;
public void setType(String type){
this.type=type;
}
public String getType(){
return type;
}
 private boolean enableDisableTime;
public void setEnableDisableTime(boolean enableDisableTime){
this.enableDisableTime=enableDisableTime;
}
public boolean getEnableDisableTime(){
return enableDisableTime;
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
 private int pageSize;
public void setPageSize(int pageSize){
this.pageSize=pageSize;
}
public int getPageSize(){
return pageSize;
}
 private int pageNumber;
public void setPageNumber(int pageNumber){
this.pageNumber=pageNumber;
}
public int getPageNumber(){
return pageNumber;
}
 private boolean displayAfterVisited;
public void setDisplayAfterVisited(boolean displayAfterVisited){
this.displayAfterVisited=displayAfterVisited;
}
public boolean getDisplayAfterVisited(){
return displayAfterVisited;
}
 
} 