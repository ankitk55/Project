package com.Ankit.Restaurant_Management_Service_API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String adminName;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    LocalDateTime adminCreationTimeStamp;

   @Pattern(regexp = "^[A-Za-z]+\\d+@admin\\.com$")  //  email format should be anki23@admin.com is valid..
    private  String adminEmail;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String adminPassword;
}
