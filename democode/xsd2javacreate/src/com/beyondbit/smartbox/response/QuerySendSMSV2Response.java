package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.SendSMSListV2;

 public  class QuerySendSMSV2Response extends Response {
 private int rangeTotal;
public void setRangeTotal(int rangeTotal){
this.rangeTotal=rangeTotal;
}
public int getRangeTotal(){
return rangeTotal;
}
 
private SendSMSListV2 sendSMSList;
public void setSendSMSList(SendSMSListV2 sendSMSList){
this.sendSMSList=sendSMSList;
}
public SendSMSListV2 getSendSMSList(){
return sendSMSList;
}
 
} 