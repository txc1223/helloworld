package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.CalendarGroup;

import java.io.Serializable;
 public  class GetCustomCalendarGroupListResponse extends Response  implements Serializable{
 
private CalendarGroup[] calendarGroup;
private boolean hasCalendarGroup=false;
public boolean getHasCalendarGroup(){
return hasCalendarGroup;
}
public void setHasCalendarGroup(boolean hasCalendarGroup){
this.hasCalendarGroup=hasCalendarGroup;
}
public void setCalendarGroup(CalendarGroup[] calendarGroup){
this.hasCalendarGroup=true;
this.calendarGroup=calendarGroup;
}
public CalendarGroup[] getCalendarGroup(){
return calendarGroup;
}
 
} 