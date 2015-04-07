package com.beyondbit.smartbox.common;
 public  class SmsInfoV2 {
 private String signer;
public void setSigner(String signer){
this.signer=signer;
}
public String getSigner(){
return signer;
}
 private int priority=5;
public void setPriority(int priority){
this.priority=priority;
}
public int getPriority(){
return priority;
}
 private String level="L";
public void setLevel(String level){
this.level=level;
}
public String getLevel(){
return level;
}
 private String sMSContent;
public void setSMSContent(String sMSContent){
this.sMSContent=sMSContent;
}
public String getSMSContent(){
return sMSContent;
}
 private boolean isNeedReply;
private boolean hasIsNeedReply=false;
public boolean getHasIsNeedReply(){
return hasIsNeedReply;
}
public void setHasIsNeedReply(boolean hasIsNeedReply){
this.hasIsNeedReply=hasIsNeedReply;
}
public void setIsNeedReply(boolean isNeedReply){
this.hasIsNeedReply=true;
this.isNeedReply=isNeedReply;
}
public boolean getIsNeedReply(){
return isNeedReply;
}
 private boolean isNeedRemind;
private boolean hasIsNeedRemind=false;
public boolean getHasIsNeedRemind(){
return hasIsNeedRemind;
}
public void setHasIsNeedRemind(boolean hasIsNeedRemind){
this.hasIsNeedRemind=hasIsNeedRemind;
}
public void setIsNeedRemind(boolean isNeedRemind){
this.hasIsNeedRemind=true;
this.isNeedRemind=isNeedRemind;
}
public boolean getIsNeedRemind(){
return isNeedRemind;
}
 private java.util.Calendar replyExpireTime;
private boolean hasReplyExpireTime=false;
public boolean getHasReplyExpireTime(){
return hasReplyExpireTime;
}
public void setHasReplyExpireTime(boolean hasReplyExpireTime){
this.hasReplyExpireTime=hasReplyExpireTime;
}
public void setReplyExpireTime(java.util.Calendar replyExpireTime){
this.hasReplyExpireTime=true;
this.replyExpireTime=replyExpireTime;
}
public java.util.Calendar getReplyExpireTime(){
return replyExpireTime;
}
 private String linkID;
public void setLinkID(String linkID){
this.linkID=linkID;
}
public String getLinkID(){
return linkID;
}
 private String sendMode;
public void setSendMode(String sendMode){
this.sendMode=sendMode;
}
public String getSendMode(){
return sendMode;
}
 private int delayType;
private boolean hasDelayType=false;
public boolean getHasDelayType(){
return hasDelayType;
}
public void setHasDelayType(boolean hasDelayType){
this.hasDelayType=hasDelayType;
}
public void setDelayType(int delayType){
this.hasDelayType=true;
this.delayType=delayType;
}
public int getDelayType(){
return delayType;
}
 private int delaySecond;
private boolean hasDelaySecond=false;
public boolean getHasDelaySecond(){
return hasDelaySecond;
}
public void setHasDelaySecond(boolean hasDelaySecond){
this.hasDelaySecond=hasDelaySecond;
}
public void setDelaySecond(int delaySecond){
this.hasDelaySecond=true;
this.delaySecond=delaySecond;
}
public int getDelaySecond(){
return delaySecond;
}
 private java.util.Calendar delayTime;
private boolean hasDelayTime=false;
public boolean getHasDelayTime(){
return hasDelayTime;
}
public void setHasDelayTime(boolean hasDelayTime){
this.hasDelayTime=hasDelayTime;
}
public void setDelayTime(java.util.Calendar delayTime){
this.hasDelayTime=true;
this.delayTime=delayTime;
}
public java.util.Calendar getDelayTime(){
return delayTime;
}
 private String repeatScope;
public void setRepeatScope(String repeatScope){
this.repeatScope=repeatScope;
}
public String getRepeatScope(){
return repeatScope;
}
 private java.util.Calendar repeatStartTime;
private boolean hasRepeatStartTime=false;
public boolean getHasRepeatStartTime(){
return hasRepeatStartTime;
}
public void setHasRepeatStartTime(boolean hasRepeatStartTime){
this.hasRepeatStartTime=hasRepeatStartTime;
}
public void setRepeatStartTime(java.util.Calendar repeatStartTime){
this.hasRepeatStartTime=true;
this.repeatStartTime=repeatStartTime;
}
public java.util.Calendar getRepeatStartTime(){
return repeatStartTime;
}
 private java.util.Calendar repeatEndTime;
private boolean hasRepeatEndTime=false;
public boolean getHasRepeatEndTime(){
return hasRepeatEndTime;
}
public void setHasRepeatEndTime(boolean hasRepeatEndTime){
this.hasRepeatEndTime=hasRepeatEndTime;
}
public void setRepeatEndTime(java.util.Calendar repeatEndTime){
this.hasRepeatEndTime=true;
this.repeatEndTime=repeatEndTime;
}
public java.util.Calendar getRepeatEndTime(){
return repeatEndTime;
}
 private int repeatTimes;
private boolean hasRepeatTimes=false;
public boolean getHasRepeatTimes(){
return hasRepeatTimes;
}
public void setHasRepeatTimes(boolean hasRepeatTimes){
this.hasRepeatTimes=hasRepeatTimes;
}
public void setRepeatTimes(int repeatTimes){
this.hasRepeatTimes=true;
this.repeatTimes=repeatTimes;
}
public int getRepeatTimes(){
return repeatTimes;
}
 private String repeatMode;
public void setRepeatMode(String repeatMode){
this.repeatMode=repeatMode;
}
public String getRepeatMode(){
return repeatMode;
}
 private String repeatDesc;
public void setRepeatDesc(String repeatDesc){
this.repeatDesc=repeatDesc;
}
public String getRepeatDesc(){
return repeatDesc;
}
 
} 