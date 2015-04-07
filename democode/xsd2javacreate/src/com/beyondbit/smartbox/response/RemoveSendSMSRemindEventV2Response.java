package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.SmsIdV2;

 public  class RemoveSendSMSRemindEventV2Response extends Response {
 
private SmsIdV2 sendId;
public void setSendId(SmsIdV2 sendId){
this.sendId=sendId;
}
public SmsIdV2 getSendId(){
return sendId;
}
 
} 