package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.ptservice.common.MonthReport;

import com.beyondbit.smartbox.response.Response;

 public  class GetProjectMonthReportResponse extends Response 
{
 
private MonthReport monthReport;
public void setMonthReport(MonthReport monthReport){
this.monthReport=monthReport;
}
public MonthReport getMonthReport(){
return monthReport;
}
 
} 