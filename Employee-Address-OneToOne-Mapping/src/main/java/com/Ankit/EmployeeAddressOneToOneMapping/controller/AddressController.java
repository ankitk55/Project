package com.Ankit.EmployeeAddressOneToOneMapping.controller;

import com.Ankit.EmployeeAddressOneToOneMapping.model.Address;
import com.Ankit.EmployeeAddressOneToOneMapping.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
public class AddressController {
@Autowired
AddressService addressService;
@PostMapping("address")
public void addAddress(@RequestBody Address address){
    addressService.addAddress(address);
}
@GetMapping("address")
    public Iterable<Address>getAllAddress(){
    return addressService.getAllAddress();
}
@GetMapping("address/{id}")
    public Address getAddressById(@PathVariable Long id){
    return addressService.getAddressById(id);
}

@PutMapping("address/street/{id}/{street}")
public void updateAddressStreetById(@PathVariable Long id, @PathVariable String street){
    addressService.updateAddressStreetById(id,street);
}
    @PutMapping("address/city/{id}/{city}")
    public void updateAddressCityById(@PathVariable Long id,@PathVariable String city){
    addressService.updateAddressCityById(id,city);
    }
    @PutMapping("address/state/{id}/{state}")
    public void updateAddressStateById(@PathVariable Long id,@PathVariable String state){
    addressService.updateAddressStateById(id,state);
    }
    @PutMapping("address/zipcode/{id}/{zipcode}")
    public void updateAddressZipcodeById(@PathVariable Long id,@PathVariable String zipcode){
    addressService.updateAddressZipcodeById(id,zipcode);
    }

@DeleteMapping("address/{id}")
    public void deleteAddressById(@PathVariable Long id){
    addressService.deleteAddressById(id);
}
}
