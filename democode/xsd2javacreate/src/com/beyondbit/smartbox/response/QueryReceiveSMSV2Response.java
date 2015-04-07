package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.ReceiveSMSListV2;

 public  class QueryReceiveSMSV2Response extends Response {
 private int rangeTotal;
public void setRangeTotal(int rangeTotal){
this.rangeTotal=rangeTotal;
}
public int getRangeTotal(){
return rangeTotal;
}
 
private ReceiveSMSListV2 receiveSMSList;
public void setReceiveSMSList(ReceiveSMSListV2 receiveSMSList){
this.receiveSMSList=receiveSMSList;
}
public ReceiveSMSListV2 getReceiveSMSList(){
return receiveSMSList;
}
 
} 