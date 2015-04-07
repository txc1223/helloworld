package com.beyondbit.smartbox.ptservice;
 public  class Opinion {
 private String title;
public void setTitle(String title){
this.title=title;
}
public String getTitle(){
return title;
}
 private String user;
public void setUser(String user){
this.user=user;
}
public String getUser(){
return user;
}
 private String org;
public void setOrg(String org){
this.org=org;
}
public String getOrg(){
return org;
}
 private java.util.Calendar time;
private boolean hasTime=false;
public boolean getHasTime(){
return hasTime;
}
public void setHasTime(boolean hasTime){
this.hasTime=hasTime;
}
public void setTime(java.util.Calendar time){
this.hasTime=true;
this.time=time;
}
public java.util.Calendar getTime(){
return time;
}
 private String content;
public void setContent(String content){
this.content=content;
}
public String getContent(){
return content;
}
 
} 