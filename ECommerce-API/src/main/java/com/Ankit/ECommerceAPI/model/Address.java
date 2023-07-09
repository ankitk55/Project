package com.Ankit.ECommerceAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String landmark;

    @Pattern(regexp = "\\d{10}") // this annotation allowed only 10-digit number
    private String phoneNumber;
    @Pattern(regexp = "^[1-9][0-9]{5}$")      //this annotation allowed only 6-digit PinCode and Pincode should not be started with 0;
    private String zipcode;
    private  String state;

    @OneToOne
    @JoinColumn(name = "fk_userId")
    private  User user;
}
