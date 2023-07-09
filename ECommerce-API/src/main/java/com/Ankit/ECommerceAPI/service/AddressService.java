package com.Ankit.ECommerceAPI.service;

import com.Ankit.ECommerceAPI.model.Address;
import com.Ankit.ECommerceAPI.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public void addAddress(Address address) {
        addressRepo.save(address);
    }
}
