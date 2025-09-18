package com.jwt.auth_service.service;

import com.jwt.auth_service.model.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);
    List<Product> getAllProducts();

    Product updateProduct(Product product);
    boolean deleteProduct(String productId);


}
