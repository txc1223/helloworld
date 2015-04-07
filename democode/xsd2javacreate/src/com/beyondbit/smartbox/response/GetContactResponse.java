package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.Contact;

 public  class GetContactResponse extends Response {
 
private Contact contact;
public void setContact(Contact contact){
this.contact=contact;
}
public Contact getContact(){
return contact;
}
 
} 