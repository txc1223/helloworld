package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.DetailCalendar;

import java.io.Serializable;
 public  class GetPersonnelCalendarResponse extends Response  implements Serializable{
 
private DetailCalendar detailCalendar;
private boolean hasDetailCalendar=false;
public boolean getHasDetailCalendar(){
return hasDetailCalendar;
}
public void setHasDetailCalendar(boolean hasDetailCalendar){
this.hasDetailCalendar=hasDetailCalendar;
}
public void setDetailCalendar(DetailCalendar detailCalendar){
this.hasDetailCalendar=true;
this.detailCalendar=detailCalendar;
}
public DetailCalendar getDetailCalendar(){
return detailCalendar;
}
 
} 