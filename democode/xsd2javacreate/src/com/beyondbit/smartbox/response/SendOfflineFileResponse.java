package com.beyondbit.smartbox.response;
 public  class SendOfflineFileResponse extends Response {
 private String id;
public void setId(String id){
this.id=id;
}
public String getId(){
return id;
}
 private String uploadServer;
public void setUploadServer(String uploadServer){
this.uploadServer=uploadServer;
}
public String getUploadServer(){
return uploadServer;
}
 
} 