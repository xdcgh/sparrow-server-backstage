package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.generate.Area;
import com.xdc.sparrowShop.service.AreaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@RequestMapping("/api/backstage/")
public class AreaController {
    private final AreaService areaService;

    public AreaController(AreaService areaService) {
        this.areaService = areaService;
    }

    @GetMapping("area")
    @ResponseBody
    public List<Area> getAreaList(HttpServletResponse response) {
        return areaService.getAreaList();
    }
}
