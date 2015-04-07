package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class AcceptMonthReportRequest extends Request 
{
 private String monthReportCode;
public void setMonthReportCode(String monthReportCode){
this.monthReportCode=monthReportCode;
}
public String getMonthReportCode(){
return monthReportCode;
}
 private String remark;
public void setRemark(String remark){
this.remark=remark;
}
public String getRemark(){
return remark;
}
 private boolean action;
public void setAction(boolean action){
this.action=action;
}
public boolean getAction(){
return action;
}
 
} 