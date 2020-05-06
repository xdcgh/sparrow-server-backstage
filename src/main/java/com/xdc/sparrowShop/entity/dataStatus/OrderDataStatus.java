package com.xdc.sparrowShop.entity.dataStatus;

public enum OrderDataStatus {
    待配送(),
    配送中(),
    已完成(),
    退款中(),
    已退款();


    public String getName() {
        return name();
    }
}
