package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.CalUser;

import java.io.Serializable;
 public  class QuerySubUsersResponse extends Response  implements Serializable{
 
private CalUser[] calUser;
private boolean hasCalUser=false;
public boolean getHasCalUser(){
return hasCalUser;
}
public void setHasCalUser(boolean hasCalUser){
this.hasCalUser=hasCalUser;
}
public void setCalUser(CalUser[] calUser){
this.hasCalUser=true;
this.calUser=calUser;
}
public CalUser[] getCalUser(){
return calUser;
}
 
} 