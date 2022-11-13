package com.fareye.flipzone.service;

import com.fareye.flipzone.model.ProductCategory;
import com.fareye.flipzone.repository.ProductRepository;

import java.util.List;

public interface ProductCategoryService {

    ProductCategory create(ProductCategory productCategory);

    List<ProductCategory> getCategories();

    ProductCategory getProductCategoryById(long id);

    void deleteProductCategory(long id);
}
