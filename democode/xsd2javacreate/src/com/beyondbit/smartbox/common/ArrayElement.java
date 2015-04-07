package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.ElementBase;

 public  class ArrayElement extends ElementBase {
 
private ElementBase[] value;
public void setValue(ElementBase[] value){
this.value=value;
}
public ElementBase[] getValue(){
return value;
}
 
} 