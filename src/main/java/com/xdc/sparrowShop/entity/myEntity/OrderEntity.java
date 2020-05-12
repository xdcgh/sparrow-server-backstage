package com.xdc.sparrowShop.entity.myEntity;

import com.xdc.sparrowShop.generate.Address;
import com.xdc.sparrowShop.generate.Fresh;
import com.xdc.sparrowShop.generate.MyOrder;
import com.xdc.sparrowShop.generate.Shop;

import java.text.SimpleDateFormat;
import java.util.List;

public class OrderEntity {
    private Shop shop;
    private Address address;
    private List<Fresh> freshList;

    private int id;
    private int userId;
    private int shopId;
    private int totalMoney;
    private int addressId;
    private String status;
    private String createdAt;
    private String updatedAt;

    public OrderEntity() {
    }

    public OrderEntity(MyOrder myOrder) {
        this.setId(myOrder.getId());
        this.setUserId(myOrder.getUserId());
        this.setShopId(myOrder.getShopId());
        this.setTotalMoney(myOrder.getTotalMoney());
        this.setAddressId(myOrder.getAddressId());
        this.setStatus(myOrder.getStatus());

        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

        this.setCreatedAt(dateFormat.format(myOrder.getCreatedAt()));
        this.setUpdatedAt(dateFormat.format(myOrder.getUpdatedAt()));
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Shop getShop() {
        return shop;
    }

    public void setShop(Shop shop) {
        this.shop = shop;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Fresh> getFreshList() {
        return freshList;
    }

    public void setFreshList(List<Fresh> freshList) {
        this.freshList = freshList;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getShopId() {
        return shopId;
    }

    public void setShopId(int shopId) {
        this.shopId = shopId;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
