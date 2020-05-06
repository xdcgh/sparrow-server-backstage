package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.entity.dataStatus.ShopDataStatus;
import com.xdc.sparrowShop.generate.Shop;
import com.xdc.sparrowShop.generate.ShopExample;
import com.xdc.sparrowShop.generate.ShopMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final ShopMapper shopMapper;

    public ShopService(ShopMapper shopMapper) {
        this.shopMapper = shopMapper;
    }


    public List<Shop> getShopListByAreaId(int areaId) {
        ShopExample shopExample = new ShopExample();

        shopExample.createCriteria()
                .andAreaIdEqualTo(areaId)
                .andStatusEqualTo(ShopDataStatus.ONLINE.getName());

        return shopMapper.selectByExample(shopExample);
    }

    public Shop getShopById(int id) {
        return shopMapper.selectByPrimaryKey(id);
    }
}
