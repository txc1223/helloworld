package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.common.ComplexElement;

import com.beyondbit.smartbox.response.Response;

 public  class QuerySplitPageResponse extends Response 
{
 private int total;
public void setTotal(int total){
this.total=total;
}
public int getTotal(){
return total;
}
 
private ComplexElement[] result;
public void setResult(ComplexElement[] result){
this.result=result;
}
public ComplexElement[] getResult(){
return result;
}
 
} 