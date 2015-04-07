package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.ElementKeyValue;

 public  class ComplexElement extends ElementBase {
 
private ElementKeyValue[] property;
public void setProperty(ElementKeyValue[] property){
this.property=property;
}
public ElementKeyValue[] getProperty(){
return property;
}
 
} 