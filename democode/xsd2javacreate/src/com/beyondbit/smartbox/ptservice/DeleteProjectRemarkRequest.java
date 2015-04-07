package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class DeleteProjectRemarkRequest extends Request 
{
 private String projectRemarkId;
public void setProjectRemarkId(String projectRemarkId){
this.projectRemarkId=projectRemarkId;
}
public String getProjectRemarkId(){
return projectRemarkId;
}
 
} 