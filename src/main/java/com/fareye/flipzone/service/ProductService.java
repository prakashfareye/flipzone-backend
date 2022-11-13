package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(Product product);

    List<Product> getProducts();

    Product getProductById(long id);

    Product updateProductQuantity(long id);

    void deleteProduct(long id);
}

/*

    User createUser(User user) throws BadRequestException;

    List<User> getUsers() throws BadRequestException;

    User getUserById(long id) throws NotFoundException;

    User getUserByEmail(String email) throws NotFoundException;

    User updateUser(long id, User newUser) throws NotFoundException;

    void deleteUser(long id) throws NotFoundException;
 */