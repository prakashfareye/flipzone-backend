package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getProducts();

    List<Product> getProductsFromSearch(String keyword);

    Product getProductById(long id);

    Product updateProductQuantity(long id);

    void deleteProduct(long id);
}