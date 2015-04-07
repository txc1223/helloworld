package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class ProcessMonthReportRequest extends Request 
{
 private String monthReportCode;
public void setMonthReportCode(String monthReportCode){
this.monthReportCode=monthReportCode;
}
public String getMonthReportCode(){
return monthReportCode;
}
 private boolean finish;
public void setFinish(boolean finish){
this.finish=finish;
}
public boolean getFinish(){
return finish;
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
 private String method;
public void setMethod(String method){
this.method=method;
}
public String getMethod(){
return method;
}
 
} 