package com.beyondbit.smartbox.ptservice.common;
 public  class File {
 private String fileName;
public void setFileName(String fileName){
this.fileName=fileName;
}
public String getFileName(){
return fileName;
}
 private String publishUnit;
public void setPublishUnit(String publishUnit){
this.publishUnit=publishUnit;
}
public String getPublishUnit(){
return publishUnit;
}
 private String publisher;
public void setPublisher(String publisher){
this.publisher=publisher;
}
public String getPublisher(){
return publisher;
}
 private java.util.Calendar publishDate;
private boolean hasPublishDate=false;
public boolean getHasPublishDate(){
return hasPublishDate;
}
public void setHasPublishDate(boolean hasPublishDate){
this.hasPublishDate=hasPublishDate;
}
public void setPublishDate(java.util.Calendar publishDate){
this.hasPublishDate=true;
this.publishDate=publishDate;
}
public java.util.Calendar getPublishDate(){
return publishDate;
}
 
} 