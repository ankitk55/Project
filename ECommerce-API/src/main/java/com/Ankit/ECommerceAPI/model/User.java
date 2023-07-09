package com.Ankit.ECommerceAPI.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    @Email
    private String userEmail;
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*\\d).{6,}$")   // this annotation allowed password should match these conditions -At least One Capital Alphabet and At least one Numeric digit and length should be min 6;
    private String userPassword;
    @Pattern(regexp = "\\d{10}") // this annotation allowed only 10 digit number
    private String userPhone;


}
