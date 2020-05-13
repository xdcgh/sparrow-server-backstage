package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.PageResponse;
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
        if (newShop.getId().equals(oldShop.getId()) || oldShop.getPhone().equals("admin")) {
            newShop.setUpdatedAt(new Date());

            shopMapper.updateByPrimaryKeySelective(newShop);
        } else {
            throw HttpException.forbidden("权限错误");
        }
    }

    public void createShop(Shop shop) {
        shop.setId(null);
        shop.setStatus(ShopDataStatus.审核中.getName());

        try {
            shopMapper.insertSelective(shop);
        } catch (Exception e) {
            throw HttpException.badRequest("该手机号已经注册过");
        }
    }

    /**
     * 根据条件，获取商铺列表
     *
     * @param pageNum  当前的页码数
     * @param pageSize 当前页面大小
     * @param status   商铺的状态
     * @param name     商铺名
     * @return 筛选后的商铺列表
     */
    public PageResponse<Shop> getShopListOfApply(Integer pageNum, Integer pageSize, String status, String name) {
        // 知道有多少个元素
        // 然后才知道有多少页
        // 然后正确地进行分页

        // 过滤防止name为空
        if (name == null) {
            name = "";
        }

        int totalNumber = countShop(status, name);

        ShopExample shopExample = new ShopExample();

        if (!status.equals("审核中")) {
            shopExample.createCriteria()
                    .andNameLike("%" + name + "%")
                    .andStatusNotEqualTo("审核中");
        } else {
            shopExample.createCriteria()
                    .andNameLike("%" + name + "%")
                    .andStatusEqualTo("审核中");
        }

        shopExample.setOrderByClause("ID DESC");

        shopExample.setLimit(pageSize);
        shopExample.setOffset((pageNum - 1) * pageSize);

        List<Shop> pageShop = shopMapper.selectByExample(shopExample);

        return PageResponse.pagedData(totalNumber, pageShop);
    }

    private int countShop(String status, String name) {
        ShopExample shopExample = new ShopExample();

        if (!status.equals("审核中")) {
            shopExample.createCriteria()
                    .andNameLike("%" + name + "%")
                    .andStatusNotEqualTo("审核中");
        } else {
            shopExample.createCriteria()
                    .andNameLike("%" + name + "%")
                    .andStatusEqualTo("审核中");
        }


        return (int) shopMapper.countByExample(shopExample);
    }
}
