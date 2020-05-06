package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.entity.Response;
import com.xdc.sparrowShop.entity.dataStatus.OrderDataStatus;
import com.xdc.sparrowShop.entity.myEntity.OrderEntity;
import com.xdc.sparrowShop.generate.MyOrder;
import com.xdc.sparrowShop.service.OrderService;
import com.xdc.sparrowShop.service.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/api/wx")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }


    @PostMapping("/order")
    public void toOrder(@RequestBody OrderEntity orderEntity, HttpServletResponse response) {
        MyOrder newOrder = new MyOrder();

        newOrder.setUserId(UserContext.getCurrentUser().getId());
        newOrder.setShopId(orderEntity.getShop().getId());
        newOrder.setTotalMoney(orderEntity.getTotalMoney());
        newOrder.setAddressId(orderEntity.getAddress().getId());
        newOrder.setStatus(OrderDataStatus.待配送.getName());
        newOrder.setCreatedAt(new Date());
        newOrder.setUpdatedAt(new Date());

        orderService.createOrder(newOrder, orderEntity.getFreshList());

        response.setStatus(200);
    }

    @GetMapping("/order")
    @ResponseBody
    public Response<List<OrderEntity>> getOrderList() {
        return Response.of(orderService.getOrderList(UserContext.getCurrentUser().getId()));
    }


    @PostMapping("/order/update")
    public void updateOrderStatus(@RequestBody MyOrder myOrder, HttpServletResponse response) {
        orderService.updateOrderStatus(myOrder);

        response.setStatus(200);
    }

    @GetMapping("/order/{id}")
    @ResponseBody
    public Response<OrderEntity> getOrderEntityByOrderId(@PathVariable("id") int orderId) {
        return Response.of(orderService.getOrderEntityByOrderId(orderId));
    }
}
