package com.beyondbit.smartbox.response;
import java.io.Serializable;
 public  class UpdateCalendarResponse extends Response  implements Serializable{
 
private String status;
private boolean hasStatus=false;
public boolean getHasStatus(){
return hasStatus;
}
public void setHasStatus(boolean hasStatus){
this.hasStatus=hasStatus;
}
public void setStatus(String status){
this.hasStatus=true;
this.status=status;
}
public String getStatus(){
return status;
}
 
} 