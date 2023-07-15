package com.Ankit.Student_model_with_mappings.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Laptop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long laptopId;

    private String name;
    private String brand;
    private Integer price;

    @OneToOne
    @JoinColumn(name = "fk_studentId")
    private Student student;

}
