package com.beyondbit.smartbox.request;
 public  class GetUpdateInfoRequest extends Request {
 private String client;
public void setClient(String client){
this.client=client;
}
public String getClient(){
return client;
}
 private String deviceId;
public void setDeviceId(String deviceId){
this.deviceId=deviceId;
}
public String getDeviceId(){
return deviceId;
}
 
} 