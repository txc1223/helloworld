package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.SmsPersonV2;

 public  class ReceiveSMSV2 {
 private int receiveID;
public void setReceiveID(int receiveID){
this.receiveID=receiveID;
}
public int getReceiveID(){
return receiveID;
}
 private int linkSendID;
private boolean hasLinkSendID=false;
public boolean getHasLinkSendID(){
return hasLinkSendID;
}
public void setHasLinkSendID(boolean hasLinkSendID){
this.hasLinkSendID=hasLinkSendID;
}
public void setLinkSendID(int linkSendID){
this.hasLinkSendID=true;
this.linkSendID=linkSendID;
}
public int getLinkSendID(){
return linkSendID;
}
 private String subjectNo;
public void setSubjectNo(String subjectNo){
this.subjectNo=subjectNo;
}
public String getSubjectNo(){
return subjectNo;
}
 
private SmsPersonV2 sender;
public void setSender(SmsPersonV2 sender){
this.sender=sender;
}
public SmsPersonV2 getSender(){
return sender;
}
 private String sMSContent;
public void setSMSContent(String sMSContent){
this.sMSContent=sMSContent;
}
public String getSMSContent(){
return sMSContent;
}
 private java.util.Calendar receiveTime;
public void setReceiveTime(java.util.Calendar receiveTime){
this.receiveTime=receiveTime;
}
public java.util.Calendar getReceiveTime(){
return receiveTime;
}
 
} 