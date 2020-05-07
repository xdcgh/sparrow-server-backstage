package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.generate.FreshType;
import com.xdc.sparrowShop.service.FreshTypeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/backstage/")
public class FreshTypeController {
    private final FreshTypeService freshTypeService;

    public FreshTypeController(FreshTypeService freshTypeService) {
        this.freshTypeService = freshTypeService;
    }

    @GetMapping("freshType")
    @ResponseBody
    public List<FreshType> getFreshType() {
        return freshTypeService.getFreshType();
    }
}
