package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.ptservice.common.ProjectRemark;

import com.beyondbit.smartbox.response.Response;

 public  class QueryProjectRemarkListResponse extends Response 
{
 
private ProjectRemark[] projectRemark;
public void setProjectRemark(ProjectRemark[] projectRemark){
this.projectRemark=projectRemark;
}
public ProjectRemark[] getProjectRemark(){
return projectRemark;
}
 
} 