package com.Ankit.Restaurant_Management_Service_API.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "foodOrder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Integer foodQuantity;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String status ="Order received";

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDateTime orderCreationTimeStamp;



    @ManyToOne
    @JoinColumn(name = "fk_userId")


    private User user;


    @ManyToMany
    @JoinTable(name = "fk_order_food",joinColumns = @JoinColumn(name = "fk_OrderId"),inverseJoinColumns = @JoinColumn(name = "fk_foodId"))
    private List<Food> food;

}
