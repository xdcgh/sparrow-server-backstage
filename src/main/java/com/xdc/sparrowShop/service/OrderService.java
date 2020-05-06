package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.entity.myEntity.OrderEntity;
import com.xdc.sparrowShop.generate.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService {
    private final MyOrderMapper myOrderMapper;
    private final OrderFreshMapper orderFreshMapper;
    private final ShopMapper shopMapper;
    private final FreshMapper freshMapper;
    private final AddressMapper addressMapper;
    private final UserMapper userMapper;

    public OrderService(MyOrderMapper orderMapper, OrderFreshMapper orderFreshMapper,
                        ShopMapper shopMapper, FreshMapper freshMapper, AddressMapper addressMapper,
                        UserMapper userMapper) {
        this.myOrderMapper = orderMapper;
        this.orderFreshMapper = orderFreshMapper;
        this.shopMapper = shopMapper;
        this.freshMapper = freshMapper;
        this.addressMapper = addressMapper;
        this.userMapper = userMapper;
    }


    public void createOrder(MyOrder newOrder, List<Fresh> freshList) {
        myOrderMapper.insertSelective(newOrder);

        insertFreshList(freshList, newOrder.getId());

        // 更新用户的账户
        User currentUser = UserContext.getCurrentUser();

        currentUser.setAccount(currentUser.getAccount() - newOrder.getTotalMoney());
        currentUser.setUpdatedAt(new Date());

        userMapper.updateByPrimaryKeySelective(currentUser);
    }

    /**
     * 将生鲜数组的生鲜，批量插入到 orderFresh 表中
     *
     * @param freshList 生鲜数组
     * @param orderId   关联的订单Id
     */
    private void insertFreshList(List<Fresh> freshList, int orderId) {
        freshList.forEach(fresh -> {
            OrderFresh orderFresh = new OrderFresh();

            // 保存下单是的生鲜价格和数量
            orderFresh.setOrderId(orderId);
            orderFresh.setFreshId(fresh.getId());
            orderFresh.setAmount(fresh.getCount());
            orderFresh.setPrice(fresh.getPrice());

            orderFreshMapper.insert(orderFresh);
        });
    }

    public List<OrderEntity> getOrderList(Integer userId) {
        MyOrderExample orderExample = new MyOrderExample();

        orderExample.createCriteria()
                .andUserIdEqualTo(userId);

        // 设置倒序
        orderExample.setOrderByClause("ID DESC");

        List<MyOrder> myOrders = myOrderMapper.selectByExample(orderExample);

        List<OrderEntity> resultList = new ArrayList<>();

        myOrders.forEach(myOrder -> {
            // 最后依次推入到 resultList 中
            resultList.add(getOrderEntityByMyOrder(myOrder));
        });

        return resultList;
    }

    /**
     * 通过 myOrder 里面各个外键id 获取到外键对应的实体
     * 如 shop，FreshList, address
     *
     * @param myOrder 订单实体
     * @return 返回重填好shop freshList address 实体的对象
     */
    private OrderEntity getOrderEntityByMyOrder(MyOrder myOrder) {
        // 继承myOrder 的原有信息
        OrderEntity orderEntity = new OrderEntity(myOrder);

        // 根据每一个订单的 shopId -> shop,
        // orderId -> 所有的 freshId -> 找到相应 fresh -> freshList 中
        // addressId -> address
        Shop shop = shopMapper.selectByPrimaryKey(myOrder.getShopId());
        List<Fresh> freshList = getFreshListByOrderId(myOrder.getId());
        Address address = addressMapper.selectByPrimaryKey(myOrder.getAddressId());

        orderEntity.setShop(shop);
        orderEntity.setFreshList(freshList);
        orderEntity.setAddress(address);

        return orderEntity;
    }

    private List<Fresh> getFreshListByOrderId(Integer orderId) {
        OrderFreshExample orderFreshExample = new OrderFreshExample();

        orderFreshExample.createCriteria()
                .andOrderIdEqualTo(orderId);

        List<OrderFresh> orderFreshList = orderFreshMapper.selectByExample(orderFreshExample);

        List<Fresh> freshList = new ArrayList<>();

        orderFreshList.forEach(orderFresh -> {
            Fresh fresh = freshMapper.selectByPrimaryKey(orderFresh.getFreshId());

            // 还原当时生鲜下单时的价格和数量，给前端展示
            fresh.setCount(orderFresh.getAmount());
            fresh.setPrice(orderFresh.getPrice());

            freshList.add(fresh);
        });


        return freshList;
    }

    public void updateOrderStatus(MyOrder myOrder) {
        myOrder.setUpdatedAt(new Date());

        myOrderMapper.updateByPrimaryKeySelective(myOrder);
    }

    public OrderEntity getOrderEntityByOrderId(int orderId) {
        return getOrderEntityByMyOrder(myOrderMapper.selectByPrimaryKey(orderId));
    }
}
