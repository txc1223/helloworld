package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.SmsIdV2;

 public  class RemoveReceiveSMSRemindEventV2Response extends Response {
 
private SmsIdV2 receiveId;
public void setReceiveId(SmsIdV2 receiveId){
this.receiveId=receiveId;
}
public SmsIdV2 getReceiveId(){
return receiveId;
}
 
} 