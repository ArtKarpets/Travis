package com.kart.springboot.service;

import com.kart.springboot.dao.ProductDao;
import com.kart.springboot.model.Product;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public void createProduct(Product product) {
        log.debug("Create product", product);
        productDao.addProduct(product);
    }

    @Override
    public String deleteProduct(Product product) {
        log.debug("Delete product", product);
        productDao.deleteProduct(product);
        return "Product " + product + " delete";
    }

    @Override
    public Product findProductById(Long productId) {
        log.debug("Find product by id", productId);
        return productDao.getProductById(productId);
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAllProduct();
    }
}
