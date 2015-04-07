package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.CategoryType;

 public  class ContactCategory {
 private String contactCategoryCode;
public void setContactCategoryCode(String contactCategoryCode){
this.contactCategoryCode=contactCategoryCode;
}
public String getContactCategoryCode(){
return contactCategoryCode;
}
 private String contactCategoryName;
public void setContactCategoryName(String contactCategoryName){
this.contactCategoryName=contactCategoryName;
}
public String getContactCategoryName(){
return contactCategoryName;
}
 
private CategoryType categoryType;
public void setCategoryType(CategoryType categoryType){
this.categoryType=categoryType;
}
public CategoryType getCategoryType(){
return categoryType;
}
 
} 