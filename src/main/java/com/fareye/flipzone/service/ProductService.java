package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Product;
import org.springframework.security.core.parameters.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    Product createProduct(Product product);

    List<Product> getProducts();

    List<Product> getProductByCategory(long id);

    List<Product> getProductByUserId(long id);

    List<Product> getProductsFromSearch(String keyword);

    Product getProductById(long id);

    Product updateProductQuantity(long id, int quantity);

    void deleteProduct(long id);

    List<Product> findTopSellingProducts();
}