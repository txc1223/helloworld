package com.beyondbit.smartbox.request;
 public  class SetIconRequest extends Request {
 private String iconCode;
public void setIconCode(String iconCode){
this.iconCode=iconCode;
}
public String getIconCode(){
return iconCode;
}
 private byte[] icon;
private boolean hasIcon=false;
public boolean getHasIcon(){
return hasIcon;
}
public void setHasIcon(boolean hasIcon){
this.hasIcon=hasIcon;
}
public void setIcon(byte[] icon){
this.hasIcon=true;
this.icon=icon;
}
public byte[] getIcon(){
return icon;
}
 
} 