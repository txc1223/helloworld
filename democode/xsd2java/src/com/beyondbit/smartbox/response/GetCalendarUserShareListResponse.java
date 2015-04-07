package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.UserShare;

import java.io.Serializable;
 public  class GetCalendarUserShareListResponse extends Response  implements Serializable{
 
private UserShare[] userShare;
private boolean hasUserShare=false;
public boolean getHasUserShare(){
return hasUserShare;
}
public void setHasUserShare(boolean hasUserShare){
this.hasUserShare=hasUserShare;
}
public void setUserShare(UserShare[] userShare){
this.hasUserShare=true;
this.userShare=userShare;
}
public UserShare[] getUserShare(){
return userShare;
}
 
} 