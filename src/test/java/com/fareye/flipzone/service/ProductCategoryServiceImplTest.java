package com.fareye.flipzone.service;

import com.fareye.flipzone.model.ProductCategory;
import com.fareye.flipzone.model.User;
import com.fareye.flipzone.repository.ProductCategoryRepository;
import com.fareye.flipzone.repository.ProductRepository;
import com.fareye.flipzone.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductCategoryServiceImplTest {

    @Mock
    private ProductCategoryRepository productCategoryRepository;
    @InjectMocks
    ProductCategoryServiceImpl productCategoryService;


    private ProductCategory productCategory;

    @BeforeEach
    public void setup(){
        long id=2;
        productCategory = ProductCategory.builder()
                .productCategoryId(id)
                .productCategoryName("Phone")
                .productCategoryImageURL("amazon.com")
                .build();
    }

    @DisplayName("JUnit Test for Create Product Category")
    @Test
    public void createNewUserTest() {

        when(productCategoryRepository.save(productCategory)).thenReturn(productCategory);
        assertEquals(productCategory, productCategoryService.create(productCategory));
    }
    @DisplayName("JUnit Test for getting all Categories from DB")
    @Test
    public void getAllCategories() {
        List<ProductCategory> productCategoriesList = new ArrayList<>();
        productCategoriesList.add(productCategory);
        when(productCategoryRepository.findAll()).thenReturn(productCategoriesList);
        assertEquals(1, productCategoryService.getCategories().size());
    }

    @DisplayName("JUnit Test for getting Product Category using Id")
    @Test
    public void getProductCategoryByIdTest() {
        long id = 2;
        when(productCategoryRepository.findById(id)).thenReturn(Optional.ofNullable(productCategory));
        assertEquals(productCategory,productCategoryService.getProductCategoryById(id));
    }

    @DisplayName("JUnit Test for getting Product category using Id Exception case")
    @Test
    public void getProductCategoryByIdTestException() {
        long id = 2;
        assertThrows(FileSystemNotFoundException.class,()->{productCategoryService.getProductCategoryById(id);});
    }




    @DisplayName("JUnit Test for Deleting Product Category using Id")
    @Test
    public void deleteProductCategoryTest(){
        long id = 1;
        when(productCategoryRepository.findById(id)).thenReturn(Optional.ofNullable(productCategory));

        productCategoryService.deleteProductCategory(id);
        verify(productCategoryRepository, times(1)).deleteById(id);}


    @DisplayName("JUnit Test for Deleting Product Category using Id Exception case")
    @Test
    public void deleteProductCategoryTest_Exception(){
        long id = 2;
        assertThrows(FileSystemNotFoundException.class,()->{productCategoryService.deleteProductCategory(id);});
    }

}