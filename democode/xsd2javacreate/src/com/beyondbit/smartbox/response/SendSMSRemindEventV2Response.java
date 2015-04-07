package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.SendSMSV2;

 public  class SendSMSRemindEventV2Response extends Response {
 
private SendSMSV2 sendSMS;
public void setSendSMS(SendSMSV2 sendSMS){
this.sendSMS=sendSMS;
}
public SendSMSV2 getSendSMS(){
return sendSMS;
}
 
} 