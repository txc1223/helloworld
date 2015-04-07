package com.beyondbit.smartbox.request;
 public  class GetPersonnelCalendarRequest extends Request {
 private String userUid;
public void setUserUid(String userUid){
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
 private String itemID;
public void setItemID(String itemID){
this.itemID=itemID;
}
public String getItemID(){
return itemID;
}
 
} 