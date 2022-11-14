package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Cart;
import com.fareye.flipzone.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;


    @Override
    public List<Cart> getCart() {

       List<Cart>cartList=cartRepository.findAll();
       return  cartList;
    }
}
