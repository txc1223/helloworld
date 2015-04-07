package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.SmsSignerListV2;

 public  class QuerySignerInfoV2Response extends Response {
 
private SmsSignerListV2 signerList;
public void setSignerList(SmsSignerListV2 signerList){
this.signerList=signerList;
}
public SmsSignerListV2 getSignerList(){
return signerList;
}
 
} 