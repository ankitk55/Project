package com.Ankit.ECommerceAPI.service;

import com.Ankit.ECommerceAPI.model.Product;
import com.Ankit.ECommerceAPI.model.ProductCategory;
import com.Ankit.ECommerceAPI.repository.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    IProductRepo productRepo;

    public void addProduct(Product product) {
        productRepo.save((product));
    }

    public Iterable<Product> getAllProducts() {
        return productRepo.findAll();
    }
    public List<Product> getProductByCategory(ProductCategory productCategory){
        return productRepo.findProductByProductCategory(productCategory);
    }

    public void deleteProductById(Integer id) {
        productRepo.deleteById(id);
    }
}
