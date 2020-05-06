package com.xdc.sparrowShop.entity.dataStatus;

public enum AddressDefaultDataStatus {
    NO(),
    YES();


    public String getName() {
        return name().toLowerCase();
    }
}
