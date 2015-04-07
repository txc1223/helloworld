package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.ContactGroupList;

 public  class GetContactGroupsByCategoryResponse extends Response {
 
private ContactGroupList contactGroupList;
public void setContactGroupList(ContactGroupList contactGroupList){
this.contactGroupList=contactGroupList;
}
public ContactGroupList getContactGroupList(){
return contactGroupList;
}
 
} 