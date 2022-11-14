package com.fareye.flipzone.service;

import com.fareye.flipzone.model.ProductCategory;
import com.fareye.flipzone.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService{

    @Autowired
    ProductCategoryRepository productCategoryRepository;

    @Override
    public ProductCategory create(ProductCategory productCategory) {
        return productCategoryRepository.save(productCategory);
    }

    @Override
    public List<ProductCategory> getCategories() {
        return productCategoryRepository.findAll();
    }

    @Override
    public ProductCategory getProductCategoryById(long id) {
        return productCategoryRepository.findById(id).orElseThrow(
                () -> new FileSystemNotFoundException("Category Not Found"));
    }

    @Override
    public void deleteProductCategory(long id) {
        productCategoryRepository.findById(id).orElseThrow(
                () -> new FileSystemNotFoundException("Category Not Found"));

        productCategoryRepository.deleteById(id);
    }
}
