package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.OfflineFile;

 public  class GetOfflineFileResponse extends Response {
 
private OfflineFile offlineFile;
public void setOfflineFile(OfflineFile offlineFile){
this.offlineFile=offlineFile;
}
public OfflineFile getOfflineFile(){
return offlineFile;
}
 
} 