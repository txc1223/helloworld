package com.beyondbit.smartbox.common;
 public  class Calendar {
 private String itemID;
public void setItemID(String itemID){
this.itemID=itemID;
}
public String getItemID(){
return itemID;
}
 private String subject;
public void setSubject(String subject){
this.subject=subject;
}
public String getSubject(){
return subject;
}
 private java.util.Calendar start;
public void setStart(java.util.Calendar start){
this.start=start;
}
public java.util.Calendar getStart(){
return start;
}
 private java.util.Calendar end;
public void setEnd(java.util.Calendar end){
this.end=end;
}
public java.util.Calendar getEnd(){
return end;
}
 private String isAllDayEvent;
public void setIsAllDayEvent(String isAllDayEvent){
this.isAllDayEvent=isAllDayEvent;
}
public String getIsAllDayEvent(){
return isAllDayEvent;
}
 private String isMeetingRequest="1";
public void setIsMeetingRequest(String isMeetingRequest){
this.isMeetingRequest=isMeetingRequest;
}
public String getIsMeetingRequest(){
return isMeetingRequest;
}
 private String isReadOnly="1";
public void setIsReadOnly(String isReadOnly){
this.isReadOnly=isReadOnly;
}
public String getIsReadOnly(){
return isReadOnly;
}
 private String userName;
public void setUserName(String userName){
this.userName=userName;
}
public String getUserName(){
return userName;
}
 private String attendees;
public void setAttendees(String attendees){
this.attendees=attendees;
}
public String getAttendees(){
return attendees;
}
 private String attendeNames;
public void setAttendeNames(String attendeNames){
this.attendeNames=attendeNames;
}
public String getAttendeNames(){
return attendeNames;
}
 private String otherAttendees;
public void setOtherAttendees(String otherAttendees){
this.otherAttendees=otherAttendees;
}
public String getOtherAttendees(){
return otherAttendees;
}
 private String location;
public void setLocation(String location){
this.location=location;
}
public String getLocation(){
return location;
}
 private String extendField1;
public void setExtendField1(String extendField1){
this.extendField1=extendField1;
}
public String getExtendField1(){
return extendField1;
}
 
} 