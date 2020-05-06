package com.xdc.sparrowShop.controller;

import com.xdc.sparrowShop.entity.HttpException;
import com.xdc.sparrowShop.entity.Response;
import com.xdc.sparrowShop.generate.Address;
import com.xdc.sparrowShop.generate.Area;
import com.xdc.sparrowShop.service.AddressService;
import com.xdc.sparrowShop.service.UserContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/api/wx")
public class AddressController {
    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/address")
    @ResponseBody
    public Response<List<Address>> address() {
        return Response.of(addressService.getAddressListByUserId(UserContext.getCurrentUser().getId()));
    }

    @PostMapping("/address/{addressId}")
    public void updateDefaultAddress(@PathVariable("addressId") int addressId, HttpServletResponse response) {
        addressService.updateDefaultAddressById(addressId);
        response.setStatus(200);
    }

    @PostMapping("/address")
    @ResponseBody
    public Response<String> addAddress(@RequestBody Address address, HttpServletResponse response) {
        try {
            addressService.addUserAddress(address);
            return Response.of("添加成功", null);
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }

    @GetMapping("/address/{addressId}")
    @ResponseBody
    public Response<Address> getAddressById(@PathVariable("addressId") int addressId) {
        return Response.of(addressService.getAddressById(addressId));
    }

    @PostMapping("/address/update")
    @ResponseBody
    public Response<String> updateAddress(@RequestBody Address address, HttpServletResponse response) {
        try {
            addressService.updateUserAddress(address);
            return Response.of("更新成功", null);
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }

    @DeleteMapping("/address/{addressId}")
    @ResponseBody
    public Response<String> deleteAddressById(@PathVariable("addressId") int addressId, HttpServletResponse response) {
        try {
            addressService.deleteAddressById(addressId);
            return Response.of("删除成功", null);
        } catch (HttpException e) {
            response.setStatus(e.getStatusCode());
            return Response.of(e.getMessage(), null);
        }
    }

    @GetMapping("/address/default")
    @ResponseBody
    public Response<Address> getDefaultAddress() {
        return addressService.getDefaultAddressByUserId(UserContext.getCurrentUser().getId());
    }

    @GetMapping("/address/areaList")
    @ResponseBody
    public Response<List<Area>> getAreaList() {
        return Response.of(addressService.getAreaList());
    }
}
