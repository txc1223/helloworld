package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.SmsIdListV2;

 public  class QueryReceiveSMSIDV2Response extends Response {
 
private SmsIdListV2 receiveSMSIDListV2;
public void setReceiveSMSIDListV2(SmsIdListV2 receiveSMSIDListV2){
this.receiveSMSIDListV2=receiveSMSIDListV2;
}
public SmsIdListV2 getReceiveSMSIDListV2(){
return receiveSMSIDListV2;
}
 
} 