package com.beyondbit.smartbox.request;
 public  class SendIMCacheRequest extends Request {
 private String recieverUid;
public void setRecieverUid(String recieverUid){
this.recieverUid=recieverUid;
}
public String getRecieverUid(){
return recieverUid;
}
 private String sendTime;
public void setSendTime(String sendTime){
this.sendTime=sendTime;
}
public String getSendTime(){
return sendTime;
}
 private String content;
public void setContent(String content){
this.content=content;
}
public String getContent(){
return content;
}
 
} 