package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.SendSMSStatusListV2;

 public  class QuerySendSMSStatusDetailV2Response extends Response {
 private int rangeTotal;
public void setRangeTotal(int rangeTotal){
this.rangeTotal=rangeTotal;
}
public int getRangeTotal(){
return rangeTotal;
}
 
private SendSMSStatusListV2 sendSMSStatusList;
public void setSendSMSStatusList(SendSMSStatusListV2 sendSMSStatusList){
this.sendSMSStatusList=sendSMSStatusList;
}
public SendSMSStatusListV2 getSendSMSStatusList(){
return sendSMSStatusList;
}
 
} 