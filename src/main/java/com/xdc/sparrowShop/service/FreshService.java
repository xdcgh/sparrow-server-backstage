package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.entity.dataStatus.FreshDataStatus;
import com.xdc.sparrowShop.entity.myEntity.TypeFreshList;
import com.xdc.sparrowShop.generate.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FreshService {

    private FreshMapper freshMapper;
    private FreshTypeMapper freshTypeMapper;

    public FreshService(FreshMapper freshMapper, FreshTypeMapper freshTypeMapper) {
        this.freshMapper = freshMapper;
        this.freshTypeMapper = freshTypeMapper;
    }

    /**
     * 最终返回给前台要的包含类别和商铺id，筛选过后的数据
     * [
     * {
     * id: 1,
     * name: "水果",
     * currentCount: 0,
     * freshList: [
     * {
     * id: 1,
     * name: "香橙",
     * description: "一种水果",
     * picture: "https://abc.png",
     * price: 2000,
     * stock: 18
     * },
     * ...
     * ]
     * },
     * ...
     * ]
     *
     * @param shopId 商铺id
     * @return 返回包含该商铺的所有的类型和其生鲜商品
     */
    public List<TypeFreshList> getTypeFreshListByShopId(int shopId) {
        // 第一步，拿到所有的类别
        // 第二步，依次更具所有的列表，加上当前的商铺id
        // 查找出当前类别和商铺的，生鲜有哪些，将其放入结果集中
        // 最后将结果集放回
        List<TypeFreshList> freshTypeList = getTypeFreshList();

        for (TypeFreshList item :
                freshTypeList) {
            item.setFreshList(getFreshListByTypeIdAndShopId(item.getId(), shopId));
        }

        // 过滤掉类别为空的类别
        return freshTypeList.stream()
                .filter(item -> !item.getFreshList().isEmpty()).collect(Collectors.toList());
    }

    /**
     * 根据 类别id 、商铺id 并且状态是上架的 获取所有的生鲜
     * [
     * {
     * id: 1,
     * name: "香橙",
     * description: "一种水果",
     * picture: "https://abc.png",
     * price: 2000
     * stock: 10
     * },
     * ...
     * ]
     *
     * @param typeId 类别 id
     * @param shopId 商铺 id
     * @return 返回 生鲜列表
     */
    private List<Fresh> getFreshListByTypeIdAndShopId(Integer typeId, int shopId) {
        FreshExample freshExample = new FreshExample();

        freshExample.createCriteria()
                .andTypeIdEqualTo(typeId)
                .andShopIdEqualTo(shopId)
                .andStatusEqualTo(FreshDataStatus.ONLINE.getName());

        return freshMapper.selectByExample(freshExample);
    }

    /**
     * 这个是一个转换用的，
     * 将普通类别数组，
     * 转成包含该类别下的生鲜的数组
     * 如：
     * [
     * {
     * id: 1,
     * name: "水果"，
     * current: 0,
     * freshList: null
     * },
     * ...
     * ]
     *
     * @return 返回 所有类别，且每个类别下的 生鲜是空的
     */
    public List<TypeFreshList> getTypeFreshList() {
        List<FreshType> freshTypeList = getFreshTypeList();

        List<TypeFreshList> resultList = new ArrayList<>();

        for (FreshType item :
                freshTypeList) {
            TypeFreshList currentTypeFreshList = new TypeFreshList();

            currentTypeFreshList.setId(item.getId());
            currentTypeFreshList.setName(item.getName());
            currentTypeFreshList.setCurrentCount(0);
            currentTypeFreshList.setFreshList(null);

            resultList.add(currentTypeFreshList);
        }

        return resultList;
    }

    /**
     * 获取所有类别的数组集合
     * [
     * {
     * id: 1,
     * name: "水果"
     * },
     * ...
     * ]
     *
     * @return 返回所有的生鲜类别数组
     */
    public List<FreshType> getFreshTypeList() {
        FreshTypeExample freshTypeExample = new FreshTypeExample();

        freshTypeExample.createCriteria().andIdIsNotNull();
        freshTypeExample.setOrderByClause("ID ASC");

        return freshTypeMapper.selectByExample(freshTypeExample);
    }

    public List<Fresh> getFreshListByNameAndAreaId(String freshName, int areaId) {
        FreshExample freshExample = new FreshExample();

        freshExample.createCriteria()
                .andAreaIdEqualTo(areaId)
                .andNameLike("%" + freshName + "%");

        return freshMapper.selectByExample(freshExample);
    }
}
