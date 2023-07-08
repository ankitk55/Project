package com.Ankit.EmployeeAddressOneToOneMapping.repository;

import com.Ankit.EmployeeAddressOneToOneMapping.model.Address;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface IAddressRepo extends CrudRepository<Address,Long> {
    Address findAddressById(Long id);
@Modifying
@Query(value = "UPDATE ADDRESS SET STREET = :street WHERE ID = :id",nativeQuery = true)
    void updateStreet(Long id,String street);
    @Modifying
    @Query(value = "UPDATE ADDRESS SET CITY = :city WHERE ID = :id",nativeQuery = true)
    void updateCity(Long id,String city);
    @Modifying
    @Query(value = "UPDATE ADDRESS SET STATE = :state WHERE ID = :id",nativeQuery = true)
    void updateState(Long id,String state);
    @Modifying
    @Query(value = "UPDATE ADDRESS SET ZIPCODE = :zipcode WHERE ID = :id",nativeQuery = true)
    void updateZipcode(Long id,String zipcode);
}
