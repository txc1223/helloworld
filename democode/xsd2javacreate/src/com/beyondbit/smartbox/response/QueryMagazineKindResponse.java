package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.MagazineKind;

 public  class QueryMagazineKindResponse extends Response {
 
private MagazineKind[] magazineKind;
public void setMagazineKind(MagazineKind[] magazineKind){
this.magazineKind=magazineKind;
}
public MagazineKind[] getMagazineKind(){
return magazineKind;
}
 
} 