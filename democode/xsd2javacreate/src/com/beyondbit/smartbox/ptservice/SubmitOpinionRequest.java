package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.request.Request;

 public  class SubmitOpinionRequest extends Request 
{
 private String module;
public void setModule(String module){
this.module=module;
}
public String getModule(){
return module;
}
 private String method;
public void setMethod(String method){
this.method=method;
}
public String getMethod(){
return method;
}
 private String id;
public void setId(String id){
this.id=id;
}
public String getId(){
return id;
}
 private String content;
public void setContent(String content){
this.content=content;
}
public String getContent(){
return content;
}
 
} 