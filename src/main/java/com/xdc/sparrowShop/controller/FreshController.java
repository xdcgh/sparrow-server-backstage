package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.PageResponse;
import com.xdc.sparrowShop.entity.Response;
import com.xdc.sparrowShop.generate.Fresh;
import com.xdc.sparrowShop.service.FreshService;
import com.xdc.sparrowShop.service.ShopContext;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/backstage/")
public class FreshController {
    private final FreshService freshService;

    public FreshController(FreshService freshService) {
        this.freshService = freshService;
    }

    @GetMapping("freshList")
    @ResponseBody
    public PageResponse<Fresh> getFreshList(@RequestParam("pageNum") Integer pageNum,
                                            @RequestParam("pageSize") Integer pageSize,
                                            @RequestParam("freshName") String freshName) {
        return freshService.getFreshList(pageNum, pageSize, ShopContext.getCurrentShop().getId(), freshName);
    }

    @GetMapping("fresh/{freshId}")
    @ResponseBody
    public Fresh getFreshByFreshId(@PathVariable("freshId") int freshId) {
        return freshService.getFreshByFreshId(freshId, ShopContext.getCurrentShop().getId());
    }

    @PatchMapping("fresh")
    @ResponseBody
    public Response<String> updateFresh(@RequestBody Fresh fresh, HttpServletResponse response) {
        try {
            freshService.updateFresh(fresh, ShopContext.getCurrentShop().getId());

            return null;
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }

    @DeleteMapping("fresh/{freshId}")
    @ResponseBody
    public Response<String> deleteFreshByFreshID(@PathVariable("freshId") int freshId, HttpServletResponse response) {
        try {
            freshService.deleteFresh(freshId, ShopContext.getCurrentShop().getId());

            return null;
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }

    @PostMapping("fresh")
    @ResponseBody
    public Response<String> addFresh(@RequestBody Fresh fresh, HttpServletResponse response) {
        try {
            freshService.addFresh(fresh, ShopContext.getCurrentShop().getId());

            return null;
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }
}
