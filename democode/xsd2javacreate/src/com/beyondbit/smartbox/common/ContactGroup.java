package com.beyondbit.smartbox.common;
 public  class ContactGroup {
 private String contactGroupCode;
public void setContactGroupCode(String contactGroupCode){
this.contactGroupCode=contactGroupCode;
}
public String getContactGroupCode(){
return contactGroupCode;
}
 private String contactGroupName;
public void setContactGroupName(String contactGroupName){
this.contactGroupName=contactGroupName;
}
public String getContactGroupName(){
return contactGroupName;
}
 private boolean contactGroupHasChild;
public void setContactGroupHasChild(boolean contactGroupHasChild){
this.contactGroupHasChild=contactGroupHasChild;
}
public boolean getContactGroupHasChild(){
return contactGroupHasChild;
}
 
} 