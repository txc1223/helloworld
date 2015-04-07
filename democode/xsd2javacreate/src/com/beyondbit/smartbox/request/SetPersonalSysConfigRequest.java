package com.beyondbit.smartbox.request;
import com.beyondbit.smartbox.common.ConfigList;

 public  class SetPersonalSysConfigRequest extends Request {
 
private ConfigList configs;
public void setConfigs(ConfigList configs){
this.configs=configs;
}
public ConfigList getConfigs(){
return configs;
}
 
} 