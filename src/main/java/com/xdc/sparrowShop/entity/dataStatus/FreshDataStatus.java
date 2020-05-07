package com.xdc.sparrowShop.entity.dataStatus;

public enum FreshDataStatus {
    在线(),
    下架();

    public String getName() {
        return name().toLowerCase();
    }
}
