package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.AppInfoList;

 public  class GetAppInfosResponse extends Response {
 
private AppInfoList appInfoList;
public void setAppInfoList(AppInfoList appInfoList){
this.appInfoList=appInfoList;
}
public AppInfoList getAppInfoList(){
return appInfoList;
}
 
} 