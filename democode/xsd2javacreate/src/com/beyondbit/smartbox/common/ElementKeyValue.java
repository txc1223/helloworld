package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.ElementBase;

 public  class ElementKeyValue {
 private String key;
public void setKey(String key){
this.key=key;
}
public String getKey(){
return key;
}
 
private ElementBase value;
private boolean hasValue=false;
public boolean getHasValue(){
return hasValue;
}
public void setHasValue(boolean hasValue){
this.hasValue=hasValue;
}
public void setValue(ElementBase value){
this.hasValue=true;
this.value=value;
}
public ElementBase getValue(){
return value;
}
 
} 