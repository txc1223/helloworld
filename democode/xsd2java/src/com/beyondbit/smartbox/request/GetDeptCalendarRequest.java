package com.beyondbit.smartbox.request;
import java.io.Serializable;
 public  class GetDeptCalendarRequest extends Request  implements Serializable{
 
private String userUid;
private boolean hasUserUid=false;
public boolean getHasUserUid(){
return hasUserUid;
}
public void setHasUserUid(boolean hasUserUid){
this.hasUserUid=hasUserUid;
}
public void setUserUid(String userUid){
this.hasUserUid=true;
this.userUid=userUid;
}
public String getUserUid(){
return userUid;
}
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
 private String isGetRecurringMaster;
private boolean hasIsGetRecurringMaster=false;
public boolean getHasIsGetRecurringMaster(){
return hasIsGetRecurringMaster;
}
public void setHasIsGetRecurringMaster(boolean hasIsGetRecurringMaster){
this.hasIsGetRecurringMaster=hasIsGetRecurringMaster;
}
public void setIsGetRecurringMaster(String isGetRecurringMaster){
this.hasIsGetRecurringMaster=true;
this.isGetRecurringMaster=isGetRecurringMaster;
}
public String getIsGetRecurringMaster(){
return isGetRecurringMaster;
}
 
} 