package com.Ankit.Simple.Restaurant.Application.model;

import com.Ankit.Simple.Restaurant.Application.model.categeory.Categeory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @NotNull
    private Integer restaurantId;
    @NotBlank
    private String restaurantName;
    private String restaurantAddress;
    private String restaurantPhone;
    private Categeory categeory;
    @Autowired
    private List<Menu> menu;
    private String openingHours;
    private Integer staffCount;
    private Integer tableCount;



}
