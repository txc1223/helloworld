package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.ptservice.common.Project;

import com.beyondbit.smartbox.response.Response;

 public  class QueryProjectListResponse extends Response 
{
 
private Project[] project;
public void setProject(Project[] project){
this.project=project;
}
public Project[] getProject(){
return project;
}
 
} 