package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.ContactList;

 public  class GetContactsByContactCodesResponse extends Response {
 
private ContactList contactList;
public void setContactList(ContactList contactList){
this.contactList=contactList;
}
public ContactList getContactList(){
return contactList;
}
 
} 