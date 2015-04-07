package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.FriendUidList;

 public  class GetContactsByContactCodesRequest extends Request {
 
private FriendUidList contactCodeList;
public void setContactCodeList(FriendUidList contactCodeList){
this.contactCodeList=contactCodeList;
}
public FriendUidList getContactCodeList(){
return contactCodeList;
}
 
} 