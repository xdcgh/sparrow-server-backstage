package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.PageResponse;
import com.xdc.sparrowShop.entity.Response;
import com.xdc.sparrowShop.entity.myEntity.OrderEntity;
import com.xdc.sparrowShop.generate.Address;
import com.xdc.sparrowShop.generate.MyOrder;
import com.xdc.sparrowShop.service.OrderService;
import com.xdc.sparrowShop.service.ShopContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/backstage/")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("orderList")
    @ResponseBody
    public PageResponse<MyOrder> getOrderList(@RequestParam("pageNum") Integer pageNum,
                                              @RequestParam("pageSize") Integer pageSize,
                                              @RequestParam(value = "orderId", required = false) Integer orderId) {
        return orderService.getOrderList(pageNum, pageSize, orderId, ShopContext.getCurrentShop().getId());
    }

    @PatchMapping("order")
    @ResponseBody
    public Response<String> updateOrderStatus(@RequestBody MyOrder order, HttpServletResponse response) {
        try {
            orderService.updateOrderStatus(order, ShopContext.getCurrentShop().getId());

            return null;
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }

    @GetMapping("order/address/{orderId}")
    @ResponseBody
    public Response<Address> getOrderAddress(@PathVariable("orderId") int orderId, HttpServletResponse response) {
        try {
            return Response.of(orderService.getOrderAddress(orderId, ShopContext.getCurrentShop().getId()));
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }

    @GetMapping("order/{orderId}")
    @ResponseBody
    public Response<OrderEntity> getOrderEntity(@PathVariable("orderId") int orderId, HttpServletResponse response) {
        try {
            return Response.of(orderService.getOrderEntity(orderId, ShopContext.getCurrentShop().getId()));
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }
}
