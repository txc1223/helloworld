package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.ContactCategoryList;

 public  class GetContactCategorysResponse extends Response {
 
private ContactCategoryList contactCategoryList;
public void setContactCategoryList(ContactCategoryList contactCategoryList){
this.contactCategoryList=contactCategoryList;
}
public ContactCategoryList getContactCategoryList(){
return contactCategoryList;
}
 
} 