package com.beyondbit.smartbox.response;
 public  class GetMagazineResponse extends Response {
 private String iD;
public void setID(String iD){
this.iD=iD;
}
public String getID(){
return iD;
}
 private String headContent;
public void setHeadContent(String headContent){
this.headContent=headContent;
}
public String getHeadContent(){
return headContent;
}
 private String content;
public void setContent(String content){
this.content=content;
}
public String getContent(){
return content;
}
 
} 