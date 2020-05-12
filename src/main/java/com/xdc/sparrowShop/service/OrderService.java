package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.PageResponse;
import com.xdc.sparrowShop.entity.myEntity.OrderEntity;
import com.xdc.sparrowShop.generate.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private final MyOrderMapper orderMapper;
    private final OrderFreshMapper orderFreshMapper;

    private final UserService userService;
    private final AddressService addressService;
    private final ShopService shopService;
    private final FreshService freshService;

    public OrderService(MyOrderMapper orderMapper, OrderFreshMapper orderFreshMapper, UserService userService, AddressService addressService, ShopService shopService, FreshService freshService) {
        this.orderMapper = orderMapper;
        this.orderFreshMapper = orderFreshMapper;
        this.userService = userService;
        this.addressService = addressService;
        this.shopService = shopService;
        this.freshService = freshService;
    }


    public PageResponse<MyOrder> getOrderList(Integer pageNum, Integer pageSize, Integer orderId, Integer shopId) {
        // 知道有多少个元素
        // 然后才知道有多少页
        // 然后正确地进行分页

        int totalNumber = countOrder(orderId, shopId);

        MyOrderExample orderExample = new MyOrderExample();

        if (orderId != null) {
            orderExample.createCriteria()
                    .andShopIdEqualTo(shopId)
                    .andIdEqualTo(orderId);
        } else {
            orderExample.createCriteria()
                    .andShopIdEqualTo(shopId);
        }

        // 设置倒序
        orderExample.setOrderByClause("ID DESC");

        orderExample.setLimit(pageSize);
        orderExample.setOffset((pageNum - 1) * pageSize);

        List<MyOrder> pageOrder = orderMapper.selectByExample(orderExample);

        return PageResponse.pagedData(totalNumber, pageOrder);
    }

    private int countOrder(Integer orderId, Integer shopId) {
        MyOrderExample orderExample = new MyOrderExample();

        if (orderId != null) {
            orderExample.createCriteria()
                    .andShopIdEqualTo(shopId)
                    .andIdEqualTo(orderId);
        } else {
            orderExample.createCriteria()
                    .andShopIdEqualTo(shopId);
        }

        return (int) orderMapper.countByExample(orderExample);
    }

    public void updateOrderStatus(MyOrder order, Integer shopId) {
        try {
            getOrderByOrderId(order.getId(), shopId);
        } catch (Exception e) {
            throw HttpException.forbidden("权限错误");
        }

        order.setUpdatedAt(new Date());

        // 如果是更改到已退款，则要返现回给当前用户
        if (order.getStatus().equals("已退款")) {
            userService.updateAccount(order.getUserId(), order.getTotalMoney());
        }

        orderMapper.updateByPrimaryKeySelective(order);
    }

    private MyOrder getOrderByOrderId(Integer id, Integer shopId) {
        MyOrderExample orderExample = new MyOrderExample();

        orderExample.createCriteria()
                .andIdEqualTo(id)
                .andShopIdEqualTo(shopId);

        return orderMapper.selectByExample(orderExample).get(0);
    }

    /**
     * 通过订单id 获取当前订单的收货地址信息
     *
     * @param orderId 订单编号
     * @param shopId  商铺编号
     */
    public Address getOrderAddress(int orderId, Integer shopId) {
        try {
            getOrderByOrderId(orderId, shopId);
        } catch (Exception e) {
            throw HttpException.forbidden("权限错误");
        }

        Integer addressId = orderMapper.selectByPrimaryKey(orderId).getAddressId();

        return addressService.getAddressById(addressId);
    }

    /**
     * 先判断当前订单编号，和申请查询的店铺编号是否匹配
     * 如果匹配即可查询
     *
     * @param orderId 订单编号
     * @param shopId  商铺编号
     * @return 订单完整实体
     */
    public OrderEntity getOrderEntity(int orderId, Integer shopId) {
        return getOrderEntityByMyOrder(getOrderByOrderId(orderId, shopId));
    }

    /**
     * 通过完整的订单实体，去查找其所有的外键实体，并组装起来
     *
     * @param myOrder 订单实体
     * @return 完整的订单实体
     */
    private OrderEntity getOrderEntityByMyOrder(MyOrder myOrder) {
        // 继承myOrder 的原有信息
        OrderEntity orderEntity = new OrderEntity(myOrder);

        // 根据每一个订单的 shopId -> shop,
        // orderId -> 所有的 freshId -> 找到相应 fresh -> freshList 中
        // addressId -> address
        Shop shop = shopService.getShopById(myOrder.getShopId());
        List<Fresh> freshList = getFreshListByOrderId(myOrder.getId());
        Address address = addressService.getAddressById(myOrder.getAddressId());

        orderEntity.setShop(shop);
        orderEntity.setFreshList(freshList);
        orderEntity.setAddress(address);

        return orderEntity;
    }

    /**
     * 获取当前订单所有的生鲜列表
     *
     * @param orderId 订单编号
     * @return 生鲜列表
     */
    private List<Fresh> getFreshListByOrderId(Integer orderId) {
        OrderFreshExample orderFreshExample = new OrderFreshExample();

        orderFreshExample.createCriteria()
                .andOrderIdEqualTo(orderId);

        List<OrderFresh> orderFreshList = orderFreshMapper.selectByExample(orderFreshExample);

        List<Fresh> freshList = new ArrayList<>();

        orderFreshList.forEach(orderFresh -> {
            Fresh fresh = freshService.getFreshById(orderFresh.getFreshId());

            // 还原当时生鲜下单时的价格和数量，给前端展示
            fresh.setCount(orderFresh.getAmount());
            fresh.setPrice(orderFresh.getPrice());

            freshList.add(fresh);
        });


        return freshList;
    }
}
