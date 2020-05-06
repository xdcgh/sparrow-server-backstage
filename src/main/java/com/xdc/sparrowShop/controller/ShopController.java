package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.generate.Shop;
import com.xdc.sparrowShop.service.ShopContext;
import com.xdc.sparrowShop.service.ShopService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/backstage/")
public class ShopController {

    private final ShopService shopService;

    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("login")
    @ResponseBody
    public Shop login(@RequestBody Shop shop) {

        UsernamePasswordToken token = new UsernamePasswordToken(
                shop.getPhone(),
                shop.getPassword()
        );

        token.setRememberMe(true);

        SecurityUtils.getSubject().login(token);

        return shopService.getShopByPhone(shop.getPhone());
    }

    @GetMapping("/status")
    @ResponseBody
    public Shop loginStatus() {
        return ShopContext.getCurrentShop();
    }

    @PostMapping("logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }
}
