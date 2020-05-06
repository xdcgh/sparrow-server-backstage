package com.xdc.sparrowShop.entity.dataStatus;

public enum DataStatus {
    OK(),
    NO(),
    YES(),
    DELETED();


    public String getName() {
        return name().toLowerCase();
    }
}
