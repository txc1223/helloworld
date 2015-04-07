package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class UpdateWorkPlanRequest extends Request 
{
 private String id;
public void setId(String id){
this.id=id;
}
public String getId(){
return id;
}
 private String name;
public void setName(String name){
this.name=name;
}
public String getName(){
return name;
}
 private String type;
public void setType(String type){
this.type=type;
}
public String getType(){
return type;
}
 private String content;
public void setContent(String content){
this.content=content;
}
public String getContent(){
return content;
}
 private String address;
public void setAddress(String address){
this.address=address;
}
public String getAddress(){
return address;
}
 private java.util.Calendar beginTime;
public void setBeginTime(java.util.Calendar beginTime){
this.beginTime=beginTime;
}
public java.util.Calendar getBeginTime(){
return beginTime;
}
 private java.util.Calendar endTime;
public void setEndTime(java.util.Calendar endTime){
this.endTime=endTime;
}
public java.util.Calendar getEndTime(){
return endTime;
}
 
} 