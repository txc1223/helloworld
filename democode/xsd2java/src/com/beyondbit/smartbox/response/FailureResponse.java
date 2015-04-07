package com.beyondbit.smartbox.response;
import java.io.Serializable;
 public  class FailureResponse extends Response  implements Serializable{
 
private String code;
private boolean hasCode=false;
public boolean getHasCode(){
return hasCode;
}
public void setHasCode(boolean hasCode){
this.hasCode=hasCode;
}
public void setCode(String code){
this.hasCode=true;
this.code=code;
}
public String getCode(){
return code;
}
 private String msg;
private boolean hasMsg=false;
public boolean getHasMsg(){
return hasMsg;
}
public void setHasMsg(boolean hasMsg){
this.hasMsg=hasMsg;
}
public void setMsg(String msg){
this.hasMsg=true;
this.msg=msg;
}
public String getMsg(){
return msg;
}
 
} 