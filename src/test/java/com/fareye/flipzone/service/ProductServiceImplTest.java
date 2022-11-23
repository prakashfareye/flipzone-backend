package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Product;

import com.fareye.flipzone.repository.ProductRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.nio.file.FileSystemNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {
    @Mock
    private ProductRepository productRepository;
    @InjectMocks
    ProductServiceImpl productService;

    private Product product;

    @BeforeEach
    public void setup(){
        long id=2;
        product = Product.builder()
                .productName("Jio")
                .userId(1)
                .productPrice(25000)
                .productDescription("ghvgj")
                .productQuantity(2)
                .productImageURL("https://akm-img-a-in.tosshub.com/indiatoday/images/story/202208/Screenshot_2022-08-13_at_11.28_1200x768.png?VersionId=URQfJth94HxEn_5VQjNneWPPy.CwDykK")
                .categoryId(2)
                .build();}

        @DisplayName("JUnit Test for Create Product")
        @Test
        public void createNewProductTest() {

            when(productRepository.save(product)).thenReturn(product);
            assertEquals(product, productService.createProduct(product));

    }

    @DisplayName("JUnit Test for getting all products from DB")
    @Test
    public void getAllProducts() {
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findAll()).thenReturn(productList);
        assertEquals(1, productService.getProducts().size());
    }

    @DisplayName("JUnit Test for getting Product using category id")
    @Test
    public void getProductByCategoryTest() {
        long id=2;
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.productByCategory(id)).thenReturn(productList);
        assertEquals(productList,productService.getProductByCategory(id));
    }

    @DisplayName("JUnit Test for getting Product using user id")
    @Test
    public void getProductByUserIdTest() {
        long id=2;
        List<Product> productList = new ArrayList<>();
        productList.add(product);
        when(productRepository.findByUserId(id)).thenReturn(productList);
        assertEquals(productList,productService.getProductByUserId(id));
    }

    @DisplayName("JUnit Test for getting Product using productId")
    @Test
    public void getProductByIdTest() {
        long id = 2;
        when(productRepository.findById(id)).thenReturn(Optional.ofNullable(product));
        assertEquals(product,productService.getProductById(id));
    }

    @DisplayName("JUnit Test for getting Product using productId Exception case")
    @Test
    public void getProductByIdTestException() {
        long id = 2;
        assertThrows(FileSystemNotFoundException.class,()->{productService.getProductById(id);});
    }

    @DisplayName("JUnit Test for Updating product using Id and newProduct object")
    @Test
    public void updateProductQuantityTest(){
        long id = 2;
        int quantity=4;
        when(productRepository.findById(id)).thenReturn(Optional.ofNullable(product));
        int currentQuantity = product.getProductQuantity()-1;
        product.setProductQuantity(currentQuantity);
        when(productRepository.save(product)).thenReturn(product);
        assertEquals(product , productService.updateProductQuantity(id,quantity));
    }

    @DisplayName("JUnit Test for Updating product using Id and newProduct object Exception")
    @Test
    public void updateProductQuantityExceptionTest(){
        long id = 2;
        int quantity=4;
        assertThrows(FileSystemNotFoundException.class,()->{productService.updateProductQuantity(id,quantity);});
    }

    @DisplayName("JUnit Test for Deleting product using Id")
    @Test
    public void deleteProductTest(){
        long id = 1;
        when(productRepository.findById(id)).thenReturn(Optional.ofNullable(product));

        productService.deleteProduct(id);
        verify(productRepository, times(1)).deleteById(id);}


    @DisplayName("JUnit Test for Deleting Product using Id Exception case")
    @Test
    public void deleteUserTest_Exception(){
        long id = 2;
        assertThrows(FileSystemNotFoundException.class,()->{productService.deleteProduct(id);});
    }

}