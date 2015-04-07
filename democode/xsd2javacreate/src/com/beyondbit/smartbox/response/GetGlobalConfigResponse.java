package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.Config;

 public  class GetGlobalConfigResponse extends Response {
 
private Config[] config;
public void setConfig(Config[] config){
this.config=config;
}
public Config[] getConfig(){
return config;
}
 
} 