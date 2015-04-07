package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.UserSignatureList;

 public  class GetUserSignatureResponse extends Response {
 
private UserSignatureList userSignatureList;
public void setUserSignatureList(UserSignatureList userSignatureList){
this.userSignatureList=userSignatureList;
}
public UserSignatureList getUserSignatureList(){
return userSignatureList;
}
 
} 