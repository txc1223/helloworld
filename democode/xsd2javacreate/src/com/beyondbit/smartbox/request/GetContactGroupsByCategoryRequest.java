package com.beyondbit.smartbox.request;
 public  class GetContactGroupsByCategoryRequest extends Request {
 private String parentCategoryCode;
public void setParentCategoryCode(String parentCategoryCode){
this.parentCategoryCode=parentCategoryCode;
}
public String getParentCategoryCode(){
return parentCategoryCode;
}
 
} 