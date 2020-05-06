package com.xdc.sparrowShop.entity.dataStatus;

public enum FreshDataStatus {
    ONLINE(),
    STOPPING();

    public String getName() {
        return name().toLowerCase();
    }
}
