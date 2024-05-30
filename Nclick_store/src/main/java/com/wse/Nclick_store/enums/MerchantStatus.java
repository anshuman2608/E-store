package com.wse.Nclick_store.enums;

public enum MerchantStatus {
      DRAFT("DRAFT"),
    ENABLE("ENABLE"),
    DISABLE("DISABLE");
    private String type;
    MerchantStatus(String type){
        this.type=type;
    }
    public String getType(){
        return type;
    }
}
