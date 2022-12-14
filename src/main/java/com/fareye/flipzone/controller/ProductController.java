package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.Product;
import com.fareye.flipzone.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping
    public ResponseEntity<Product> create(@RequestBody Product newProduct) {
        Product product = productService.createProduct(newProduct);
        return new ResponseEntity<>(product, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Product>> get() {
        List<Product> products = productService.getProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/c/{id}")
    public ResponseEntity<List<Product>> getProductByCategoryId(@PathVariable long id) {
        List<Product> products = productService.getProductByCategory(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/u/{id}")
    public ResponseEntity<List<Product>> getProductByUserId(@PathVariable long id) {
        List<Product> products = productService.getProductByUserId(id);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/search/{keyword}")
    public ResponseEntity<List<Product>> getFromSearch(@PathVariable String keyword) {
        List<Product> products = productService.getProductsFromSearch(keyword);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}/{quantity}")
    public Product updateProductQuantity(@PathVariable long id, @PathVariable int quantity) {
        return productService.updateProductQuantity(id, quantity);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return "Product Deleted";
    }

    @GetMapping("/top")
    public  List<Product> getTopSellingProducts() {
        return productService.findTopSellingProducts();
    }
}