package com.beyondbit.smartbox.request;
 public  class FinishOfflineFileRequest extends Request {
 private String id;
public void setId(String id){
this.id=id;
}
public String getId(){
return id;
}
 private String dataId;
public void setDataId(String dataId){
this.dataId=dataId;
}
public String getDataId(){
return dataId;
}
 private boolean isCancel;
public void setIsCancel(boolean isCancel){
this.isCancel=isCancel;
}
public boolean getIsCancel(){
return isCancel;
}
 
} 