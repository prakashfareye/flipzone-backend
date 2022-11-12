package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.ProductCategory;
import com.fareye.flipzone.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;

    @PostMapping
    public ResponseEntity<ProductCategory> create(@RequestBody ProductCategory newProductCategory) {
        ProductCategory productCategory = productCategoryService.create(newProductCategory);
        return new ResponseEntity<>(productCategory, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductCategory>> get() {
        List<ProductCategory> categories = productCategoryService.getCategories();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ProductCategory getCategoryByID(@PathVariable long id) {
        return productCategoryService.getProductCategoryById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable long id) {
        productCategoryService.deleteProductCategory(id);
        return "Product Category Deleted";
    }
}
