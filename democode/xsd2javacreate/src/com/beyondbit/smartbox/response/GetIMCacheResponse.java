package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.IMCache;

 public  class GetIMCacheResponse extends Response {
 
private IMCache iMCache;
public void setIMCache(IMCache iMCache){
this.iMCache=iMCache;
}
public IMCache getIMCache(){
return iMCache;
}
 
} 