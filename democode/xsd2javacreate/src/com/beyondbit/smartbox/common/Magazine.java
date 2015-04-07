package com.beyondbit.smartbox.common;
 public  class Magazine {
 private String iD;
public void setID(String iD){
this.iD=iD;
}
public String getID(){
return iD;
}
 private String no;
public void setNo(String no){
this.no=no;
}
public String getNo(){
return no;
}
 private boolean readed;
public void setReaded(boolean readed){
this.readed=readed;
}
public boolean getReaded(){
return readed;
}
 private int visitedCount;
public void setVisitedCount(int visitedCount){
this.visitedCount=visitedCount;
}
public int getVisitedCount(){
return visitedCount;
}
 private java.util.Calendar publishTime;
private boolean hasPublishTime=false;
public boolean getHasPublishTime(){
return hasPublishTime;
}
public void setHasPublishTime(boolean hasPublishTime){
this.hasPublishTime=hasPublishTime;
}
public void setPublishTime(java.util.Calendar publishTime){
this.hasPublishTime=true;
this.publishTime=publishTime;
}
public java.util.Calendar getPublishTime(){
return publishTime;
}
 
} 