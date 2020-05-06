package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.generate.Shop;

public class ShopContext {
    private static ThreadLocal<Shop> currentShop = new ThreadLocal<>();

    public static Shop getCurrentShop() {
        return currentShop.get();
    }

    public static void setCurrentShop(Shop shop) {
        currentShop.set(shop);
    }

    public static void clearCurrentUser() {
        currentShop.remove();
    }
}
