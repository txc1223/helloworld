package com.beyondbit.smartbox.common;
 public  class OAAttachment {
 private String iD;
public void setID(String iD){
this.iD=iD;
}
public String getID(){
return iD;
}
 private String fileName;
public void setFileName(String fileName){
this.fileName=fileName;
}
public String getFileName(){
return fileName;
}
 private String contentType;
public void setContentType(String contentType){
this.contentType=contentType;
}
public String getContentType(){
return contentType;
}
 private long contentSize;
public void setContentSize(long contentSize){
this.contentSize=contentSize;
}
public long getContentSize(){
return contentSize;
}
 private java.util.Calendar sendTime;
public void setSendTime(java.util.Calendar sendTime){
this.sendTime=sendTime;
}
public java.util.Calendar getSendTime(){
return sendTime;
}
 private int kind;
private boolean hasKind=false;
public boolean getHasKind(){
return hasKind;
}
public void setHasKind(boolean hasKind){
this.hasKind=hasKind;
}
public void setKind(int kind){
this.hasKind=true;
this.kind=kind;
}
public int getKind(){
return kind;
}
 private byte[] content;
private boolean hasContent=false;
public boolean getHasContent(){
return hasContent;
}
public void setHasContent(boolean hasContent){
this.hasContent=hasContent;
}
public void setContent(byte[] content){
this.hasContent=true;
this.content=content;
}
public byte[] getContent(){
return content;
}
 
} 