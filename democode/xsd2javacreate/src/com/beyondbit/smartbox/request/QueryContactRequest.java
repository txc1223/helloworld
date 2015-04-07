package com.beyondbit.smartbox.request;
 public  class QueryContactRequest extends Request {
 private String queryPara;
public void setQueryPara(String queryPara){
this.queryPara=queryPara;
}
public String getQueryPara(){
return queryPara;
}
 private int rcount;
public void setRcount(int rcount){
this.rcount=rcount;
}
public int getRcount(){
return rcount;
}
 
} 