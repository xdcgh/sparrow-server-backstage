package com.xdc.sparrowShop.entity.myEntity;

import com.xdc.sparrowShop.generate.Shop;

import java.util.List;

public class ShopAndTypeFreshList {
    private Shop shop;
    private List<TypeFreshList> typeFreshLists;

    public ShopAndTypeFreshList() {
    }

    public ShopAndTypeFreshList(Shop shop, List<TypeFreshList> typeFreshLists) {
        this.shop = shop;
        this.typeFreshLists = typeFreshLists;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public List<TypeFreshList> getTypeFreshLists() {
        return typeFreshLists;
    }

    public void setTypeFreshLists(List<TypeFreshList> typeFreshLists) {
        this.typeFreshLists = typeFreshLists;
    }
}
