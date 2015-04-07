package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.Notice;

 public  class QueryNoticesResponse extends Response {
 
private Notice[] notice;
public void setNotice(Notice[] notice){
this.notice=notice;
}
public Notice[] getNotice(){
return notice;
}
 
} 