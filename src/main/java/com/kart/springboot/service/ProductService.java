package com.kart.springboot.service;

import com.kart.springboot.model.Product;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    void createProduct(Product product);

    String deleteProduct(Product product);

    Product findProductById(Long productId);

    List<Product> getAll();
}
