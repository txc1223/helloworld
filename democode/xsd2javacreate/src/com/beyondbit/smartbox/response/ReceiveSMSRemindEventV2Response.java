package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.SmsIdListV2;

 public  class ReceiveSMSRemindEventV2Response extends Response {
 
private SmsIdListV2 sendSMSIDListV2;
public void setSendSMSIDListV2(SmsIdListV2 sendSMSIDListV2){
this.sendSMSIDListV2=sendSMSIDListV2;
}
public SmsIdListV2 getSendSMSIDListV2(){
return sendSMSIDListV2;
}
 
} 