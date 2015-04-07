package com.beyondbit.smartbox.response;
 public  class FailureResponse extends Response {
 private String code;
public void setCode(String code){
this.code=code;
}
public String getCode(){
return code;
}
 private String msg;
public void setMsg(String msg){
this.msg=msg;
}
public String getMsg(){
return msg;
}
 
} 