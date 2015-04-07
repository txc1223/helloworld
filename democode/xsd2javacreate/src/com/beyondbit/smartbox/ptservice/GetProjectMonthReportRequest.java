package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class GetProjectMonthReportRequest extends Request 
{
 private String monthReportCode;
public void setMonthReportCode(String monthReportCode){
this.monthReportCode=monthReportCode;
}
public String getMonthReportCode(){
return monthReportCode;
}
 
} 