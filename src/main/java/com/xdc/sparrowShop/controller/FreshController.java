package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.entity.Response;
import com.xdc.sparrowShop.entity.myEntity.ShopAndTypeFreshList;
import com.xdc.sparrowShop.entity.myEntity.TypeFreshList;
import com.xdc.sparrowShop.generate.Fresh;
import com.xdc.sparrowShop.generate.Shop;
import com.xdc.sparrowShop.service.FreshService;
import com.xdc.sparrowShop.service.ShopService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wx")
public class FreshController {

    private FreshService freshService;
    private ShopService shopService;

    public FreshController(FreshService freshService, ShopService shopService) {
        this.freshService = freshService;
        this.shopService = shopService;
    }

    @GetMapping("/fresh/shop/{shopId}")
    @ResponseBody
    public Response<ShopAndTypeFreshList> getTypeFreshListByShopId(@PathVariable("shopId") int shopId) {
        List<TypeFreshList> typeFreshListByShopId = freshService.getTypeFreshListByShopId(shopId);
        Shop shop = shopService.getShopById(shopId);

        return Response.of(new ShopAndTypeFreshList(shop, typeFreshListByShopId));
    }

    @GetMapping("/fresh/search")
    @ResponseBody
    public Response<List<Fresh>> searchFreshListByAreaIdAndFreshName(@RequestParam("name") String freshName, @RequestParam("areaId") int areaId) {
        return Response.of(freshService.getFreshListByNameAndAreaId(freshName, areaId));
    }
}
