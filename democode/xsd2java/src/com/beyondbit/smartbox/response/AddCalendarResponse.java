package com.beyondbit.smartbox.response;
import java.io.Serializable;
 public  class AddCalendarResponse extends Response  implements Serializable{
 
private String itemId;
private boolean hasItemId=false;
public boolean getHasItemId(){
return hasItemId;
}
public void setHasItemId(boolean hasItemId){
this.hasItemId=hasItemId;
}
public void setItemId(String itemId){
this.hasItemId=true;
this.itemId=itemId;
}
public String getItemId(){
return itemId;
}
 
} 