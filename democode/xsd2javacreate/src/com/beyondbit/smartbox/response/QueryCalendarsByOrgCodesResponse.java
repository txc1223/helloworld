package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.OrgCalendar;

 public  class QueryCalendarsByOrgCodesResponse extends Response {
 
private OrgCalendar[] orgCalendar;
public void setOrgCalendar(OrgCalendar[] orgCalendar){
this.orgCalendar=orgCalendar;
}
public OrgCalendar[] getOrgCalendar(){
return orgCalendar;
}
 
} 