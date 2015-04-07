package com.beyondbit.smartbox.response;
 public  class GetUpdateInfoResponse extends Response {
 private String version;
public void setVersion(String version){
this.version=version;
}
public String getVersion(){
return version;
}
 private String url;
public void setUrl(String url){
this.url=url;
}
public String getUrl(){
return url;
}
 
} 