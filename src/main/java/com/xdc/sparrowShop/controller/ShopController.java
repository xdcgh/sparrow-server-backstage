package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.entity.Response;
import com.xdc.sparrowShop.generate.Shop;
import com.xdc.sparrowShop.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wx")
public class ShopController {

    private ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @GetMapping("/shop/area/{areaId}")
    @ResponseBody
    public Response<List<Shop>> getShopListByAreaId(@PathVariable("areaId") int areaId) {
        return Response.of(shopService.getShopListByAreaId(areaId));
    }

    @GetMapping("/shop/id/{id}")
    @ResponseBody
    public Response<Shop> getShopById(@PathVariable("id") int id) {
        return Response.of(shopService.getShopById(id));
    }
}
