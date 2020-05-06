package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.entity.dataStatus.AddressDefaultDataStatus;
import com.xdc.sparrowShop.entity.dataStatus.DataStatus;
import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.Response;
import com.xdc.sparrowShop.generate.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class AddressService {
    private final AreaMapper areaMapper;
    private final AddressMapper addressMapper;

    public AddressService(AreaMapper areaMapper, AddressMapper addressMapper) {
        this.areaMapper = areaMapper;
        this.addressMapper = addressMapper;
    }

    public List<Address> getAddressListByUserId(Integer id) {
        AddressExample addressExample = new AddressExample();

        addressExample.createCriteria().andUserIdEqualTo(id);

        return addressMapper.selectByExample(addressExample);
    }

    /**
     * 将该地址id 设置为默认
     * @param addressId 地址id
     */
    public void updateDefaultAddressById(int addressId) {
        int userId = UserContext.getCurrentUser().getId();

        setUserAllAddressIsNotDefault(userId);

        setAddressStatus(addressId, DataStatus.YES.getName());
    }

    /**
     * 设置该用户所有的地址为 非默认 no
     *
     * @param userId 用户id
     */
    public void setUserAllAddressIsNotDefault(int userId) {
        List<Address> addressList = getAddressListByUserId(userId);

        addressList.forEach(item ->
                setAddressStatus(item.getId(), DataStatus.NO.getName()));
    }

    public void setAddressStatus(int addressId, String status) {
        Address address = addressMapper.selectByPrimaryKey(addressId);

        address.setIsDefault(status);

        addressMapper.updateByPrimaryKey(address);
    }

    public void addUserAddress(Address address) {
        areaIsOpen(address.getAreaId());

        address.setUserId(UserContext.getCurrentUser().getId());
        address.setIsDefault(DataStatus.YES.getName());

        addressMapper.insert(address);

        updateDefaultAddressById(address.getId());
    }

    /**
     * 判断该地区是否有开放，抛出 400 错误
     * @param areaId 地区id
     */
    private void areaIsOpen(int areaId) {
        Area area = areaMapper.selectByPrimaryKey(areaId);

        if (Objects.isNull(area)) {
            throw HttpException.badRequest("该地区暂未开放");
        }
    }

    public Address getAddressById(int addressId) {
        // todo 可判断是否有权限查询该地址

        return addressMapper.selectByPrimaryKey(addressId);
    }

    public void updateUserAddress(Address address) {
        areaIsOpen(address.getAreaId());

        address.setUserId(UserContext.getCurrentUser().getId());
        address.setIsDefault(DataStatus.YES.getName());
        addressMapper.updateByPrimaryKey(address);

        updateDefaultAddressById(address.getId());
    }

    public void deleteAddressById(int addressId) {
        // todo 可鉴权
        int rowCount = addressMapper.deleteByPrimaryKey(addressId);

        if (rowCount != 1) {
            throw HttpException.badRequest("删除失败");
        }
    }

    public Response<Address> getDefaultAddressByUserId(Integer userId) {
        AddressExample example = new AddressExample();

        example.createCriteria().andUserIdEqualTo(userId)
                .andIsDefaultEqualTo(AddressDefaultDataStatus.YES.getName());

        return Response.of(addressMapper.selectByExample(example).get(0));
    }

    public List<Area> getAreaList() {
        AreaExample areaExample = new AreaExample();

        areaExample.createCriteria().andIdIsNotNull();

        return areaMapper.selectByExample(areaExample);
    }
}
