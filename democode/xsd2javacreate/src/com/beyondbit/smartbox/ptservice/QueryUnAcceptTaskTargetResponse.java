package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.ptservice.common.TaskTarget;

import com.beyondbit.smartbox.response.Response;

 public  class QueryUnAcceptTaskTargetResponse extends Response 
{
 
private TaskTarget[] taskTarget;
public void setTaskTarget(TaskTarget[] taskTarget){
this.taskTarget=taskTarget;
}
public TaskTarget[] getTaskTarget(){
return taskTarget;
}
 
} 