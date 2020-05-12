package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.PageResponse;
import com.xdc.sparrowShop.generate.Fresh;
import com.xdc.sparrowShop.generate.FreshExample;
import com.xdc.sparrowShop.generate.FreshMapper;
import com.xdc.sparrowShop.generate.ShopMapper;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class FreshService {
    private final FreshMapper freshMapper;
    private final ShopMapper shopMapper;

    public FreshService(FreshMapper freshMapper, ShopMapper shopMapper) {
        this.freshMapper = freshMapper;
        this.shopMapper = shopMapper;
    }

    public PageResponse<Fresh> getFreshList(Integer pageNum, Integer pageSize, Integer shopId, String freshName) {
        // 知道有多少个元素
        // 然后才知道有多少页
        // 然后正确地进行分页

        int totalNumber = countFresh(shopId, freshName);

        FreshExample page = new FreshExample();

        if (!freshName.equals("")) {
            page.createCriteria()
                    .andShopIdEqualTo(shopId)
                    .andNameLike("%" + freshName + "%");
        } else {
            page.createCriteria()
                    .andShopIdEqualTo(shopId);
        }

        page.setLimit(pageSize);
        page.setOffset((pageNum - 1) * pageSize);

        List<Fresh> pageFresh = freshMapper.selectByExample(page);

        return PageResponse.pagedData(totalNumber, pageFresh);
    }

    private int countFresh(Integer shopId, String freshName) {
        FreshExample freshExample = new FreshExample();


        if (!freshName.equals("")) {
            freshExample.createCriteria()
                    .andShopIdEqualTo(shopId)
                    .andNameLike("%" + freshName + "%");
        } else {
            freshExample.createCriteria()
                    .andShopIdEqualTo(shopId);
        }


        return (int) freshMapper.countByExample(freshExample);
    }

    public Fresh getFreshByFreshId(int freshId, Integer shopId) {
        FreshExample freshExample = new FreshExample();

        freshExample.createCriteria()
                .andIdEqualTo(freshId)
                .andShopIdEqualTo(shopId);

        return freshMapper.selectByExample(freshExample).get(0);
    }

    public void updateFresh(Fresh fresh, Integer shopId) {
        try {
            getFreshByFreshId(fresh.getId(), shopId);
        } catch (Exception e) {
            throw HttpException.forbidden("权限错误");
        }

        fresh.setUpdatedAt(new Date());

        if (freshMapper.updateByPrimaryKeySelective(fresh) == 0) {
            throw HttpException.badRequest("更新失败");
        }
    }

    public void deleteFresh(int freshId, Integer shopId) {
        FreshExample freshExample = new FreshExample();

        freshExample.createCriteria()
                .andIdEqualTo(freshId)
                .andShopIdEqualTo(shopId);

        if (freshMapper.deleteByExample(freshExample) == 0) {
            throw HttpException.badRequest("删除失败");
        }
    }

    public void addFresh(Fresh fresh, Integer shopId) {
        // 先查找到当前商铺的 areaId，并加入到商品中

        int areaId = getAreaIdByShopId(shopId);

        fresh.setShopId(shopId);
        fresh.setAreaId(areaId);
        fresh.setCreatedAt(new Date());
        fresh.setUpdatedAt(new Date());

        if (freshMapper.insert(fresh) == 0) {
            throw HttpException.badRequest("添加生鲜失败");
        }
    }

    private int getAreaIdByShopId(Integer shopId) {
        return shopMapper.selectByPrimaryKey(shopId).getAreaId();
    }

    public Fresh getFreshById(Integer freshId) {
        return freshMapper.selectByPrimaryKey(freshId);
    }
}
