package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.generate.FreshType;
import com.xdc.sparrowShop.generate.FreshTypeExample;
import com.xdc.sparrowShop.generate.FreshTypeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FreshTypeService {
    private final FreshTypeMapper freshTypeMapper;

    public FreshTypeService(FreshTypeMapper freshTypeMapper) {
        this.freshTypeMapper = freshTypeMapper;
    }

    public List<FreshType> getFreshType() {
        FreshTypeExample freshTypeExample = new FreshTypeExample();

        freshTypeExample.createCriteria().andIdIsNotNull();

        return freshTypeMapper.selectByExample(freshTypeExample);
    }
}
