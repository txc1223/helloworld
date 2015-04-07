package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.ConfigList;

 public  class GetPersonalSysConfigResponse extends Response {
 
private ConfigList configs;
public void setConfigs(ConfigList configs){
this.configs=configs;
}
public ConfigList getConfigs(){
return configs;
}
 
} 