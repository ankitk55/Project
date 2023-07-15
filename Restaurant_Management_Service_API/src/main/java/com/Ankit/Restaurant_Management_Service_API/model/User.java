package com.Ankit.Restaurant_Management_Service_API.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "userData")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime userCreationTimeStamp;

    @Pattern(regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.com$")
    private  String userEmail;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String userPassword;

}
