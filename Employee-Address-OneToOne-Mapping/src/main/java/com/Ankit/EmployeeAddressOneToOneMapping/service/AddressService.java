package com.Ankit.EmployeeAddressOneToOneMapping.service;

import com.Ankit.EmployeeAddressOneToOneMapping.model.Address;
import com.Ankit.EmployeeAddressOneToOneMapping.repository.IAddressRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Transactional
@Service
public class AddressService {
    @Autowired
    IAddressRepo addressRepo;
    public void addAddress(Address address) {
        addressRepo.save(address);
    }

    public Iterable<Address> getAllAddress() {
        return addressRepo.findAll();
    }

    public Address getAddressById(Long id) {
        return addressRepo.findAddressById(id);
    }

    public void deleteAddressById(Long id) {
        addressRepo.deleteById(id);
    }

    public void updateAddressStreetById(Long id,String street) {
        addressRepo.updateStreet(id,street);
    }

    public void updateAddressCityById(Long id,String city) {
        addressRepo.updateCity(id,city);
    }

    public void updateAddressStateById(Long id,String state) {
        addressRepo.updateState(id,state);
    }

    public void updateAddressZipcodeById(Long id,String zipcode) {
        addressRepo.updateZipcode(id,zipcode);
    }
}
