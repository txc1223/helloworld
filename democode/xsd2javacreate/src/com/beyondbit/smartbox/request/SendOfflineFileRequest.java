package com.beyondbit.smartbox.request;
 public  class SendOfflineFileRequest extends Request {
 private String to;
public void setTo(String to){
this.to=to;
}
public String getTo(){
return to;
}
 private String displayName;
public void setDisplayName(String displayName){
this.displayName=displayName;
}
public String getDisplayName(){
return displayName;
}
 private long size;
public void setSize(long size){
this.size=size;
}
public long getSize(){
return size;
}
 
} 