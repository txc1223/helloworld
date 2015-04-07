package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.SmsInfoV2;

import com.beyondbit.smartbox.common.SmsPersonListV2;

 public  class SendSMSV2Request extends Request {
 
private SmsPersonListV2 receiverList;
public void setReceiverList(SmsPersonListV2 receiverList){
this.receiverList=receiverList;
}
public SmsPersonListV2 getReceiverList(){
return receiverList;
}
 
private SmsInfoV2 smsInfo;
public void setSmsInfo(SmsInfoV2 smsInfo){
this.smsInfo=smsInfo;
}
public SmsInfoV2 getSmsInfo(){
return smsInfo;
}
 
} 