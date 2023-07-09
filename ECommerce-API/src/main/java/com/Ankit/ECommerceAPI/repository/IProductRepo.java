package com.Ankit.ECommerceAPI.repository;

import com.Ankit.ECommerceAPI.model.Product;
import com.Ankit.ECommerceAPI.model.ProductCategory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IProductRepo extends CrudRepository<Product,Integer> {
    List<Product> findProductByProductCategory(ProductCategory productCategory);
}
