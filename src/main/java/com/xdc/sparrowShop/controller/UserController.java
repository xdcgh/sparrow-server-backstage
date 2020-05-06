package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.Response;
import com.xdc.sparrowShop.entity.myEntity.Account;
import com.xdc.sparrowShop.entity.myEntity.WxUserInfo;
import com.xdc.sparrowShop.generate.User;
import com.xdc.sparrowShop.service.UserContext;
import com.xdc.sparrowShop.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/wx")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    @ResponseBody
    public User login(@RequestBody WxUserInfo wxUserInfo) {
        User user = userService.createUserIfNotExist(wxUserInfo);

        UsernamePasswordToken token = new UsernamePasswordToken(
                user.getId().toString(),
                user.getOpenid()
        );

        token.setRememberMe(true);

        SecurityUtils.getSubject().login(token);

        return user;
    }

    @PostMapping("/status")
    public Response<User> loginStatus() {
        return Response.of(UserContext.getCurrentUser());
    }

    @PostMapping("/recharge")
    @ResponseBody
    public Response<User> recharge(@RequestBody Account account, HttpServletResponse response) {
        try {
            return Response.of(userService.toRecharge(account));
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }

    @PostMapping("/withdraw")
    @ResponseBody
    public Response<User> withdraw(@RequestBody Account account, HttpServletResponse response) {
        try {
            return Response.of(userService.toWithdraw(account));
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }
}
