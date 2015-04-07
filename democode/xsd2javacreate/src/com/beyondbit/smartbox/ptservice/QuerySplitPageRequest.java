package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.common.ComplexElement;

import com.beyondbit.smartbox.request.Request;

 public  class QuerySplitPageRequest extends Request 
{
 private String module;
public void setModule(String module){
this.module=module;
}
public String getModule(){
return module;
}
 private String method;
public void setMethod(String method){
this.method=method;
}
public String getMethod(){
return method;
}
 private int pageIndex=0;
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
 private int pageSize=20;
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
 private java.util.Calendar startTime;
private boolean hasStartTime=false;
public boolean getHasStartTime(){
return hasStartTime;
}
public void setHasStartTime(boolean hasStartTime){
this.hasStartTime=hasStartTime;
}
public void setStartTime(java.util.Calendar startTime){
this.hasStartTime=true;
this.startTime=startTime;
}
public java.util.Calendar getStartTime(){
return startTime;
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
 
private ComplexElement searchCondition;
private boolean hasSearchCondition=false;
public boolean getHasSearchCondition(){
return hasSearchCondition;
}
public void setHasSearchCondition(boolean hasSearchCondition){
this.hasSearchCondition=hasSearchCondition;
}
public void setSearchCondition(ComplexElement searchCondition){
this.hasSearchCondition=true;
this.searchCondition=searchCondition;
}
public ComplexElement getSearchCondition(){
return searchCondition;
}
 
} 