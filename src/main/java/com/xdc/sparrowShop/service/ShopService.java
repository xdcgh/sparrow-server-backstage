package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.entity.dataStatus.ShopDataStatus;
import com.xdc.sparrowShop.generate.Shop;
import com.xdc.sparrowShop.generate.ShopExample;
import com.xdc.sparrowShop.generate.ShopMapper;
import com.xdc.sparrowShop.generate.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Shop getShopByPhone(String phone) {
        ShopExample shopExample = new ShopExample();

        shopExample.createCriteria().andPhoneEqualTo(phone);

        return shopMapper.selectByExample(shopExample).get(0);
    }

    public String getPasswordByPhone(String phone) {
        return getShopByPhone(phone).getPassword();
    }
}
