package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.CalOrg;

 public  class QuerySubOrgsResponse extends Response {
 
private CalOrg[] calOrg;
public void setCalOrg(CalOrg[] calOrg){
this.calOrg=calOrg;
}
public CalOrg[] getCalOrg(){
return calOrg;
}
 
} 