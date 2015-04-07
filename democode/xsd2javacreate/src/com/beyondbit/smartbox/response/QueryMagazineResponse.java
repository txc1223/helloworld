package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.Magazine;

 public  class QueryMagazineResponse extends Response {
 private int total;
public void setTotal(int total){
this.total=total;
}
public int getTotal(){
return total;
}
 
private Magazine[] magazine;
public void setMagazine(Magazine[] magazine){
this.magazine=magazine;
}
public Magazine[] getMagazine(){
return magazine;
}
 
} 