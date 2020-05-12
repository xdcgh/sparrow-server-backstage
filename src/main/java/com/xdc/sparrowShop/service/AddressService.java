package com.xdc.sparrowShop.service;

import com.xdc.sparrowShop.generate.Address;
import com.xdc.sparrowShop.generate.AddressMapper;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    private final AddressMapper addressMapper;

    public AddressService(AddressMapper addressMapper) {
        this.addressMapper = addressMapper;
    }

    public Address getAddressById(Integer addressId) {
        return addressMapper.selectByPrimaryKey(addressId);
    }
}
