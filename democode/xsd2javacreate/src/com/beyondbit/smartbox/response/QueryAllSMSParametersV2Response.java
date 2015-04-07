package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.SmsParameterListV2;

 public  class QueryAllSMSParametersV2Response extends Response {
 
private SmsParameterListV2 parameterList;
public void setParameterList(SmsParameterListV2 parameterList){
this.parameterList=parameterList;
}
public SmsParameterListV2 getParameterList(){
return parameterList;
}
 
} 