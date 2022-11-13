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

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable long id) {
        return productService.getProductById(id);
    }

    @PutMapping("/{id}")
    public Product updateProductQuantity(@PathVariable long id) {
        return productService.updateProductQuantity(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable long id) {
        productService.deleteProduct(id);
        return "Product Deleted";
    }


}