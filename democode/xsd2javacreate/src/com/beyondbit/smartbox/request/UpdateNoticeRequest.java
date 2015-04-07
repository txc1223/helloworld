package com.beyondbit.smartbox.request;
 public  class UpdateNoticeRequest extends Request {
 private String noticeId;
public void setNoticeId(String noticeId){
this.noticeId=noticeId;
}
public String getNoticeId(){
return noticeId;
}
 private String title;
public void setTitle(String title){
this.title=title;
}
public String getTitle(){
return title;
}
 private String content;
public void setContent(String content){
this.content=content;
}
public String getContent(){
return content;
}
 private String publicScope;
public void setPublicScope(String publicScope){
this.publicScope=publicScope;
}
public String getPublicScope(){
return publicScope;
}
 private String recievers;
public void setRecievers(String recievers){
this.recievers=recievers;
}
public String getRecievers(){
return recievers;
}
 private java.util.Calendar beginTime;
private boolean hasBeginTime=false;
public boolean getHasBeginTime(){
return hasBeginTime;
}
public void setHasBeginTime(boolean hasBeginTime){
this.hasBeginTime=hasBeginTime;
}
public void setBeginTime(java.util.Calendar beginTime){
this.hasBeginTime=true;
this.beginTime=beginTime;
}
public java.util.Calendar getBeginTime(){
return beginTime;
}
 private java.util.Calendar expireTime;
private boolean hasExpireTime=false;
public boolean getHasExpireTime(){
return hasExpireTime;
}
public void setHasExpireTime(boolean hasExpireTime){
this.hasExpireTime=hasExpireTime;
}
public void setExpireTime(java.util.Calendar expireTime){
this.hasExpireTime=true;
this.expireTime=expireTime;
}
public java.util.Calendar getExpireTime(){
return expireTime;
}
 
} 