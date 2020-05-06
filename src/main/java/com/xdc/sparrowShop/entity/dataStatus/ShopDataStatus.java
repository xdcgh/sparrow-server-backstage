package com.xdc.sparrowShop.entity.dataStatus;

public enum ShopDataStatus {
    ONLINE(),
    STOPPING;



    public String getName() {
        return name().toLowerCase();
    }
}
