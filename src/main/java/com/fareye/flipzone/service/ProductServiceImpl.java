package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Product;
import com.fareye.flipzone.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.parameters.*;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> getProductsFromSearch(String keyword) {
        if (keyword == null) return productRepository.findAll();
        return productRepository.search(keyword);
    }

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductByCategory(long id) {
        return productRepository.productByCategory(id);
    }

    @Override
    public List<Product> getProductByUserId(long id) {
        return productRepository.findByUserId(id);
    }

    @Override
    public Product getProductById(long id) {
        return productRepository.findById(id).orElseThrow(
                () -> new FileSystemNotFoundException("Product Not Found"));
    }

    @Override
    public Product updateProductQuantity(long id, int quantityPlaced) {
        Product oldProduct = productRepository.findById(id).orElseThrow(
                () -> new FileSystemNotFoundException("Product Not Found"));
        int currentQuantity = oldProduct.getProductQuantity();
        oldProduct.setProductQuantity((currentQuantity - quantityPlaced));
        return productRepository.save(oldProduct);
    }

    @Override
    public void deleteProduct(long id) {
        productRepository.findById(id).orElseThrow(
                () -> new FileSystemNotFoundException("Product Not Found"));
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> findTopSellingProducts() {
        return productRepository.findTopSellingProducts();
    }
}
