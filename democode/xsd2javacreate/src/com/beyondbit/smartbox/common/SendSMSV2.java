package com.beyondbit.smartbox.common;
 public  class SendSMSV2 {
 private int sMSSendID;
public void setSMSSendID(int sMSSendID){
this.sMSSendID=sMSSendID;
}
public int getSMSSendID(){
return sMSSendID;
}
 private String subjectNo;
public void setSubjectNo(String subjectNo){
this.subjectNo=subjectNo;
}
public String getSubjectNo(){
return subjectNo;
}
 private java.util.Calendar sendTime;
private boolean hasSendTime=false;
public boolean getHasSendTime(){
return hasSendTime;
}
public void setHasSendTime(boolean hasSendTime){
this.hasSendTime=hasSendTime;
}
public void setSendTime(java.util.Calendar sendTime){
this.hasSendTime=true;
this.sendTime=sendTime;
}
public java.util.Calendar getSendTime(){
return sendTime;
}
 private String firstReceiver;
public void setFirstReceiver(String firstReceiver){
this.firstReceiver=firstReceiver;
}
public String getFirstReceiver(){
return firstReceiver;
}
 private String sMSContent;
public void setSMSContent(String sMSContent){
this.sMSContent=sMSContent;
}
public String getSMSContent(){
return sMSContent;
}
 private int sendStatus;
public void setSendStatus(int sendStatus){
this.sendStatus=sendStatus;
}
public int getSendStatus(){
return sendStatus;
}
 private boolean isLocked;
private boolean hasIsLocked=false;
public boolean getHasIsLocked(){
return hasIsLocked;
}
public void setHasIsLocked(boolean hasIsLocked){
this.hasIsLocked=hasIsLocked;
}
public void setIsLocked(boolean isLocked){
this.hasIsLocked=true;
this.isLocked=isLocked;
}
public boolean getIsLocked(){
return isLocked;
}
 private int replayCount;
public void setReplayCount(int replayCount){
this.replayCount=replayCount;
}
public int getReplayCount(){
return replayCount;
}
 private java.util.Calendar createTime;
public void setCreateTime(java.util.Calendar createTime){
this.createTime=createTime;
}
public java.util.Calendar getCreateTime(){
return createTime;
}
 
} 