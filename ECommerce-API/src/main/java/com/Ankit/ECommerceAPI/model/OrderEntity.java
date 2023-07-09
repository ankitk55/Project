package com.Ankit.ECommerceAPI.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;
    private Integer productQuantity;
    @ManyToMany
     @JoinTable(name = "fk_order_product", joinColumns = @JoinColumn(name = "fk_orderId"),inverseJoinColumns = @JoinColumn(name = "fk_productId"))
    private List<Product> products;

     @ManyToOne
     @JoinColumn(name = "fk_user_id")
     private  User user;

    @ ManyToOne
    @JoinColumn(name = "fk_address")
     private Address address;

}
