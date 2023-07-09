package com.Ankit.ECommerceAPI.controller;

import com.Ankit.ECommerceAPI.model.Address;
import com.Ankit.ECommerceAPI.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("address")
    public void addAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }

}
