package com.beyondbit.smartbox.common;
import com.beyondbit.smartbox.common.UserSignature;

 public  class UserSignatureList {
 
private UserSignature[] userSignature;
public void setUserSignature(UserSignature[] userSignature){
this.userSignature=userSignature;
}
public UserSignature[] getUserSignature(){
return userSignature;
}
 
} 