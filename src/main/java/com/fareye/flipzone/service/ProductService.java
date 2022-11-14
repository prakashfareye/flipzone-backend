package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ProductService {

    Product createProduct(Product product);

    List<Product> getProducts();

    List<Product> getProductByCategory(long id);

    List<Product> getProductsFromSearch(String keyword);

    Product getProductById(long id);

    Product updateProductQuantity(long id);

    void deleteProduct(long id);
}