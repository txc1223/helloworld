package com.beyondbit.smartbox.request;
 public  class QueryReceiveSMSIDV2Request extends Request {
 private int beginID;
private boolean hasBeginID=false;
public boolean getHasBeginID(){
return hasBeginID;
}
public void setHasBeginID(boolean hasBeginID){
this.hasBeginID=hasBeginID;
}
public void setBeginID(int beginID){
this.hasBeginID=true;
this.beginID=beginID;
}
public int getBeginID(){
return beginID;
}
 private int endID;
private boolean hasEndID=false;
public boolean getHasEndID(){
return hasEndID;
}
public void setHasEndID(boolean hasEndID){
this.hasEndID=hasEndID;
}
public void setEndID(int endID){
this.hasEndID=true;
this.endID=endID;
}
public int getEndID(){
return endID;
}
 
} 