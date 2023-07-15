package com.Ankit.Student_model_with_mappings.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId;
    private String zipcode;
    private String district;
    private String state;
    private String country;

    @OneToOne
    @JoinColumn(name = "fk_studentId")
   private Student student;
}
