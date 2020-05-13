package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.PageResponse;
import com.xdc.sparrowShop.entity.Response;
import com.xdc.sparrowShop.generate.Shop;
import com.xdc.sparrowShop.service.ShopContext;
import com.xdc.sparrowShop.service.ShopService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

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

        if (shop.getPhone().equals("admin")) {
            Shop adminShop = new Shop();

            adminShop.setPhone("admin");

            return adminShop;
        }

        return shopService.getShopByPhone(shop.getPhone());
    }

    @GetMapping("status")
    @ResponseBody
    public Shop loginStatus() {
        return ShopContext.getCurrentShop();
    }

    @PostMapping("logout")
    public void logout() {
        SecurityUtils.getSubject().logout();
    }

    @PatchMapping("shop")
    @ResponseBody
    public Response<Shop> updateShop(@RequestBody Shop shop, HttpServletResponse response) {
        try {
            shopService.updateShop(shop, ShopContext.getCurrentShop());

            return null;
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }

    @PostMapping("register")
    @ResponseBody
    public Response<String> createdShop(@RequestBody Shop shop, HttpServletResponse response) {
        try {
            shopService.createShop(shop);

            return null;
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }

    @GetMapping("shopList")
    @ResponseBody
    public PageResponse<Shop> getShopListOfApply(@RequestParam("pageNum") Integer pageNum,
                                                 @RequestParam("pageSize") Integer pageSize,
                                                 @RequestParam("status") String status,
                                                 @RequestParam(value = "name", required = false) String name) {
        return shopService.getShopListOfApply(pageNum, pageSize, status, name);
    }
}
