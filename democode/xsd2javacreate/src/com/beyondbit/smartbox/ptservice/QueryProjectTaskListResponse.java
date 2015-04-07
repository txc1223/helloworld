package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.ptservice.common.Task;

import com.beyondbit.smartbox.response.Response;

 public  class QueryProjectTaskListResponse extends Response 
{
 
private Task[] task;
public void setTask(Task[] task){
this.task=task;
}
public Task[] getTask(){
return task;
}
 
} 