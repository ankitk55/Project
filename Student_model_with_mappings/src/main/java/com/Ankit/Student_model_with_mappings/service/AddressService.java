package com.Ankit.Student_model_with_mappings.service;

import com.Ankit.Student_model_with_mappings.model.Address;
import com.Ankit.Student_model_with_mappings.repository.IAddressRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;

    public void addAddress(Address address) {
        addressRepo.save(address);
    }

    public List<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public Address getAddressById(Long addressId) {
        return addressRepo.findById(addressId).orElse(null);
    }

    public void deleteAddress(Long addressId) {
        addressRepo.deleteById(addressId);
    }
}
