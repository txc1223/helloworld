package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.MagazineArea;

 public  class QueryMagazineAreaResponse extends Response {
 
private MagazineArea[] magazineArea;
public void setMagazineArea(MagazineArea[] magazineArea){
this.magazineArea=magazineArea;
}
public MagazineArea[] getMagazineArea(){
return magazineArea;
}
 
} 