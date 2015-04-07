package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.OrgCalendar;

import java.io.Serializable;
 public  class QueryCalendarsByOrgCodesResponse extends Response  implements Serializable{
 
private OrgCalendar[] orgCalendar;
private boolean hasOrgCalendar=false;
public boolean getHasOrgCalendar(){
return hasOrgCalendar;
}
public void setHasOrgCalendar(boolean hasOrgCalendar){
this.hasOrgCalendar=hasOrgCalendar;
}
public void setOrgCalendar(OrgCalendar[] orgCalendar){
this.hasOrgCalendar=true;
this.orgCalendar=orgCalendar;
}
public OrgCalendar[] getOrgCalendar(){
return orgCalendar;
}
 
} 