package com.beyondbit.smartbox.request;
 public  class QuerySendSMSStatusDetailV2Request extends Request {
 private int beginID;
public void setBeginID(int beginID){
this.beginID=beginID;
}
public int getBeginID(){
return beginID;
}
 private int endID;
public void setEndID(int endID){
this.endID=endID;
}
public int getEndID(){
return endID;
}
 
} 