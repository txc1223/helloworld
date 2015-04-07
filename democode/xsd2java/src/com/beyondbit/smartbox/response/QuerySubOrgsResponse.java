package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.CalOrg;

import java.io.Serializable;
 public  class QuerySubOrgsResponse extends Response  implements Serializable{
 
private CalOrg[] calOrg;
private boolean hasCalOrg=false;
public boolean getHasCalOrg(){
return hasCalOrg;
}
public void setHasCalOrg(boolean hasCalOrg){
this.hasCalOrg=hasCalOrg;
}
public void setCalOrg(CalOrg[] calOrg){
this.hasCalOrg=true;
this.calOrg=calOrg;
}
public CalOrg[] getCalOrg(){
return calOrg;
}
 
} 