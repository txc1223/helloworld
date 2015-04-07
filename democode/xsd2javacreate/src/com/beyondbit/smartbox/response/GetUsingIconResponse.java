package com.beyondbit.smartbox.response;
 public  class GetUsingIconResponse extends Response {
 private String iconCode;
public void setIconCode(String iconCode){
this.iconCode=iconCode;
}
public String getIconCode(){
return iconCode;
}
 private byte[] icon;
public void setIcon(byte[] icon){
this.icon=icon;
}
public byte[] getIcon(){
return icon;
}
 
} 