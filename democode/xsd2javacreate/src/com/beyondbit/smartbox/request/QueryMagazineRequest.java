package com.beyondbit.smartbox.request;
 public  class QueryMagazineRequest extends Request {
 private String magazineKindID;
public void setMagazineKindID(String magazineKindID){
this.magazineKindID=magazineKindID;
}
public String getMagazineKindID(){
return magazineKindID;
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
 
} 