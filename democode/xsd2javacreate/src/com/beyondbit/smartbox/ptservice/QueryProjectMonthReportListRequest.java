package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class QueryProjectMonthReportListRequest extends Request 
{
 private String projectCode;
public void setProjectCode(String projectCode){
this.projectCode=projectCode;
}
public String getProjectCode(){
return projectCode;
}
 private String viewMonth;
public void setViewMonth(String viewMonth){
this.viewMonth=viewMonth;
}
public String getViewMonth(){
return viewMonth;
}
 
} 