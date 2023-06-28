package com.Ankit.User.Management.System.with.Validations.model;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.time.LocalTime;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class User {
    @NotNull
   private Integer userId;
    @NotBlank
   private String userName;
    @NotNull
    private LocalDate userDOB;
    @NotNull
    @Email // this verify email is valid format or not
   private String userEmail;

    @Pattern(regexp = "^91\\d{10}$") //this Regex for 91 country code and must have be also 10 digit required for a valid phone number
    private String userPhone;
    @NotNull
    private LocalDate date;
    @NotNull
    private LocalTime time;

}
