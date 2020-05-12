package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.generate.Area;
import com.xdc.sparrowShop.generate.AreaExample;
import com.xdc.sparrowShop.generate.AreaMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaService {
    private final AreaMapper areaMapper;

    public AreaService(AreaMapper areaMapper) {
        this.areaMapper = areaMapper;
    }

    public List<Area> getAreaList() {
        AreaExample areaExample = new AreaExample();

        areaExample.createCriteria().andIdIsNotNull();

        return areaMapper.selectByExample(areaExample);
    }
}
