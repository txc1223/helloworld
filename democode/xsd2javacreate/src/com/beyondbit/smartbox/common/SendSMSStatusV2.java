package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.SmsPersonV2;

 public  class SendSMSStatusV2 {
 private int sMSSendID;
public void setSMSSendID(int sMSSendID){
this.sMSSendID=sMSSendID;
}
public int getSMSSendID(){
return sMSSendID;
}
 
private SmsPersonV2 receiver;
public void setReceiver(SmsPersonV2 receiver){
this.receiver=receiver;
}
public SmsPersonV2 getReceiver(){
return receiver;
}
 private String deviceName;
public void setDeviceName(String deviceName){
this.deviceName=deviceName;
}
public String getDeviceName(){
return deviceName;
}
 private String deviceCode;
public void setDeviceCode(String deviceCode){
this.deviceCode=deviceCode;
}
public String getDeviceCode(){
return deviceCode;
}
 private int sendStatus;
public void setSendStatus(int sendStatus){
this.sendStatus=sendStatus;
}
public int getSendStatus(){
return sendStatus;
}
 
} 