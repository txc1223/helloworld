package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.CalUser;

 public  class QuerySubUsersResponse extends Response {
 
private CalUser[] calUser;
public void setCalUser(CalUser[] calUser){
this.calUser=calUser;
}
public CalUser[] getCalUser(){
return calUser;
}
 
} 