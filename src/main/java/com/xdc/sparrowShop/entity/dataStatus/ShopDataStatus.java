package com.xdc.sparrowShop.entity.dataStatus;

public enum ShopDataStatus {
    在线(),
    停业(),
    审核中();



    public String getName() {
        return name().toLowerCase();
    }
}
