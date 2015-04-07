package com.beyondbit.smartbox.common;
 public  class Notice {
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
 private String publishUid;
public void setPublishUid(String publishUid){
this.publishUid=publishUid;
}
public String getPublishUid(){
return publishUid;
}
 private java.util.Calendar publishTime;
public void setPublishTime(java.util.Calendar publishTime){
this.publishTime=publishTime;
}
public java.util.Calendar getPublishTime(){
return publishTime;
}
 private String publisher;
public void setPublisher(String publisher){
this.publisher=publisher;
}
public String getPublisher(){
return publisher;
}
 private java.util.Calendar firstReadTime;
private boolean hasFirstReadTime=false;
public boolean getHasFirstReadTime(){
return hasFirstReadTime;
}
public void setHasFirstReadTime(boolean hasFirstReadTime){
this.hasFirstReadTime=hasFirstReadTime;
}
public void setFirstReadTime(java.util.Calendar firstReadTime){
this.hasFirstReadTime=true;
this.firstReadTime=firstReadTime;
}
public java.util.Calendar getFirstReadTime(){
return firstReadTime;
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