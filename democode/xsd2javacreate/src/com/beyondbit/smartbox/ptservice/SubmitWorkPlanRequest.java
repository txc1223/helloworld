package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class SubmitWorkPlanRequest extends Request 
{
 private String id;
public void setId(String id){
this.id=id;
}
public String getId(){
return id;
}
 private String remark;
public void setRemark(String remark){
this.remark=remark;
}
public String getRemark(){
return remark;
}
 
} 