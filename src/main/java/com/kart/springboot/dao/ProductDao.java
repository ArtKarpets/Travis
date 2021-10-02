package com.kart.springboot.dao;

import com.kart.springboot.model.Product;

import java.util.List;

public interface ProductDao {
    Product addProduct(Product product);

    void deleteProduct(Product product);

    List<Product> getAllProduct();

    Product getProductById(Long id);
}
