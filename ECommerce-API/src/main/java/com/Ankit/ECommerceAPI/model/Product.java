package com.Ankit.ECommerceAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private String productName;
    private Integer productPrice;
    private  String productDescription;
    @Enumerated(value = EnumType.STRING)
    private ProductCategory productCategory;
    private String productBrand;
}
