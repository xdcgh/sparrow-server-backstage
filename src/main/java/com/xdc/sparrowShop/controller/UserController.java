package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.PageResponse;
import com.xdc.sparrowShop.entity.Response;
import com.xdc.sparrowShop.generate.User;
import com.xdc.sparrowShop.service.ShopContext;
import com.xdc.sparrowShop.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/backstage/")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("userList")
    @ResponseBody
    public PageResponse<User> getUserList(@RequestParam("pageNum") Integer pageNum,
                                          @RequestParam("pageSize") Integer pageSize,
                                          @RequestParam(value = "nickName", required = false) String nickName) {
        return userService.getUserList(pageNum, pageSize, nickName);
    }

    @PatchMapping("user")
    @ResponseBody
    public Response<String> updateUser(@RequestBody User user, HttpServletResponse response) {
        try {
            userService.updateUser(user, ShopContext.getCurrentShop().getPhone());

            return null;
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }
}
