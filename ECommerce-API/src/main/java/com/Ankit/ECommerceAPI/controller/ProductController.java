package com.Ankit.ECommerceAPI.controller;

import com.Ankit.ECommerceAPI.model.Product;
import com.Ankit.ECommerceAPI.model.ProductCategory;
import com.Ankit.ECommerceAPI.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("product")
    public void addProduct(@RequestBody Product product){
        productService.addProduct(product);
    }
    @GetMapping("products")
    public Iterable<Product>getAllProducts(){
        return productService.getAllProducts();
    }
    @GetMapping("products/{productCategory}")
    public List<Product> getProductByCategory(@PathVariable ProductCategory productCategory){
        return productService.getProductByCategory(productCategory);
    }

    @DeleteMapping("product/{id}")
        public void deleteProductById(@PathVariable Integer id){
             productService.deleteProductById(id);
        }
    }

