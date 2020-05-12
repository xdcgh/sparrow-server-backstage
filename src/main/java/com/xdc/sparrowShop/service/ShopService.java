package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.dataStatus.ShopDataStatus;
import com.xdc.sparrowShop.generate.Shop;
import com.xdc.sparrowShop.generate.ShopExample;
import com.xdc.sparrowShop.generate.ShopMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
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
                .andStatusEqualTo(ShopDataStatus.营业.getName());

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

    public void updateShop(Shop newShop, Shop oldShop) {
        if (!newShop.getId().equals(oldShop.getId())) {
            throw HttpException.forbidden("权限错误");
        }

        newShop.setUpdatedAt(new Date());

        shopMapper.updateByPrimaryKeySelective(newShop);
    }

    public void createShop(Shop shop) {
        shop.setId(null);
        shop.setStatus(ShopDataStatus.审核中.getName());

        shopMapper.insertSelective(shop);
    }
}
