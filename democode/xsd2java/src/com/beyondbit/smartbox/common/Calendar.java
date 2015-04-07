package com.beyondbit.smartbox.common;
import java.io.Serializable;
 public  class Calendar  implements Serializable{
 
private String itemID;
private boolean hasItemID=false;
public boolean getHasItemID(){
return hasItemID;
}
public void setHasItemID(boolean hasItemID){
this.hasItemID=hasItemID;
}
public void setItemID(String itemID){
this.hasItemID=true;
this.itemID=itemID;
}
public String getItemID(){
return itemID;
}
 private String subject;
private boolean hasSubject=false;
public boolean getHasSubject(){
return hasSubject;
}
public void setHasSubject(boolean hasSubject){
this.hasSubject=hasSubject;
}
public void setSubject(String subject){
this.hasSubject=true;
this.subject=subject;
}
public String getSubject(){
return subject;
}
 private java.util.Calendar start;
private boolean hasStart=false;
public boolean getHasStart(){
return hasStart;
}
public void setHasStart(boolean hasStart){
this.hasStart=hasStart;
}
public void setStart(java.util.Calendar start){
this.hasStart=true;
this.start=start;
}
public java.util.Calendar getStart(){
return start;
}
 private java.util.Calendar end;
private boolean hasEnd=false;
public boolean getHasEnd(){
return hasEnd;
}
public void setHasEnd(boolean hasEnd){
this.hasEnd=hasEnd;
}
public void setEnd(java.util.Calendar end){
this.hasEnd=true;
this.end=end;
}
public java.util.Calendar getEnd(){
return end;
}
 private String isAllDayEvent;
private boolean hasIsAllDayEvent=false;
public boolean getHasIsAllDayEvent(){
return hasIsAllDayEvent;
}
public void setHasIsAllDayEvent(boolean hasIsAllDayEvent){
this.hasIsAllDayEvent=hasIsAllDayEvent;
}
public void setIsAllDayEvent(String isAllDayEvent){
this.hasIsAllDayEvent=true;
this.isAllDayEvent=isAllDayEvent;
}
public String getIsAllDayEvent(){
return isAllDayEvent;
}
 private String isMeetingRequest="1";
private boolean hasIsMeetingRequest=false;
public boolean getHasIsMeetingRequest(){
return hasIsMeetingRequest;
}
public void setHasIsMeetingRequest(boolean hasIsMeetingRequest){
this.hasIsMeetingRequest=hasIsMeetingRequest;
}
public void setIsMeetingRequest(String isMeetingRequest){
this.hasIsMeetingRequest=true;
this.isMeetingRequest=isMeetingRequest;
}
public String getIsMeetingRequest(){
return isMeetingRequest;
}
 private String isReadOnly="1";
private boolean hasIsReadOnly=false;
public boolean getHasIsReadOnly(){
return hasIsReadOnly;
}
public void setHasIsReadOnly(boolean hasIsReadOnly){
this.hasIsReadOnly=hasIsReadOnly;
}
public void setIsReadOnly(String isReadOnly){
this.hasIsReadOnly=true;
this.isReadOnly=isReadOnly;
}
public String getIsReadOnly(){
return isReadOnly;
}
 private String userName;
private boolean hasUserName=false;
public boolean getHasUserName(){
return hasUserName;
}
public void setHasUserName(boolean hasUserName){
this.hasUserName=hasUserName;
}
public void setUserName(String userName){
this.hasUserName=true;
this.userName=userName;
}
public String getUserName(){
return userName;
}
 private String attendees;
private boolean hasAttendees=false;
public boolean getHasAttendees(){
return hasAttendees;
}
public void setHasAttendees(boolean hasAttendees){
this.hasAttendees=hasAttendees;
}
public void setAttendees(String attendees){
this.hasAttendees=true;
this.attendees=attendees;
}
public String getAttendees(){
return attendees;
}
 private String attendeNames;
private boolean hasAttendeNames=false;
public boolean getHasAttendeNames(){
return hasAttendeNames;
}
public void setHasAttendeNames(boolean hasAttendeNames){
this.hasAttendeNames=hasAttendeNames;
}
public void setAttendeNames(String attendeNames){
this.hasAttendeNames=true;
this.attendeNames=attendeNames;
}
public String getAttendeNames(){
return attendeNames;
}
 private String otherAttendees;
private boolean hasOtherAttendees=false;
public boolean getHasOtherAttendees(){
return hasOtherAttendees;
}
public void setHasOtherAttendees(boolean hasOtherAttendees){
this.hasOtherAttendees=hasOtherAttendees;
}
public void setOtherAttendees(String otherAttendees){
this.hasOtherAttendees=true;
this.otherAttendees=otherAttendees;
}
public String getOtherAttendees(){
return otherAttendees;
}
 private String location;
private boolean hasLocation=false;
public boolean getHasLocation(){
return hasLocation;
}
public void setHasLocation(boolean hasLocation){
this.hasLocation=hasLocation;
}
public void setLocation(String location){
this.hasLocation=true;
this.location=location;
}
public String getLocation(){
return location;
}
 private String extendField1;
private boolean hasExtendField1=false;
public boolean getHasExtendField1(){
return hasExtendField1;
}
public void setHasExtendField1(boolean hasExtendField1){
this.hasExtendField1=hasExtendField1;
}
public void setExtendField1(String extendField1){
this.hasExtendField1=true;
this.extendField1=extendField1;
}
public String getExtendField1(){
return extendField1;
}
 
} 