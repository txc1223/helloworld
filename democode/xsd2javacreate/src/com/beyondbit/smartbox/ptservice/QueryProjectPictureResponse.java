package com.beyondbit.smartbox.ptservice;
import com.beyondbit.smartbox.response.Response;

 public  class QueryProjectPictureResponse extends Response 
{
 private byte[][] picture;
public void setPicture(byte[][] picture){
this.picture=picture;
}
public byte[][] getPicture(){
return picture;
}
 
} 