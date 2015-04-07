package com.beyondbit.smartbox.response;
import com.beyondbit.smartbox.common.MagazineMetaDir;

 public  class QueryMagazineMetaDirResponse extends Response {
 
private MagazineMetaDir[] magazineMetaDir;
public void setMagazineMetaDir(MagazineMetaDir[] magazineMetaDir){
this.magazineMetaDir=magazineMetaDir;
}
public MagazineMetaDir[] getMagazineMetaDir(){
return magazineMetaDir;
}
 
} 