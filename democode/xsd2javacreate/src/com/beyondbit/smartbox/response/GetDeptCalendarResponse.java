package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.DetailCalendar;

 public  class GetDeptCalendarResponse extends Response {
 
private DetailCalendar detailCalendar;
public void setDetailCalendar(DetailCalendar detailCalendar){
this.detailCalendar=detailCalendar;
}
public DetailCalendar getDetailCalendar(){
return detailCalendar;
}
 
} 