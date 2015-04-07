package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.SendSMSStatusV2;

 public  class SendSMSStatusDetailRemindEventV2Response extends Response {
 
private SendSMSStatusV2 sendSMSStatus;
public void setSendSMSStatus(SendSMSStatusV2 sendSMSStatus){
this.sendSMSStatus=sendSMSStatus;
}
public SendSMSStatusV2 getSendSMSStatus(){
return sendSMSStatus;
}
 
} 