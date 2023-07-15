package com.Ankit.Student_model_with_mappings.controller;

import com.Ankit.Student_model_with_mappings.model.Address;
import com.Ankit.Student_model_with_mappings.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressController {
    @Autowired
    AddressService addressService;
    @PostMapping("address")
    public void addAddress(@RequestBody Address address){
        addressService.addAddress(address);
    }
    @GetMapping("addresss")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
    @GetMapping("address/{addressId}")
    public Address getAddressById(@PathVariable Long addressId){
        return addressService.getAddressById(addressId);
    }

    @DeleteMapping("address/{addressId}")
    public void deleteAddress(@PathVariable Long addressId){
        addressService.deleteAddress(addressId);
    }
}
