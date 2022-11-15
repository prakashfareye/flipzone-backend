package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Cart;
import com.fareye.flipzone.model.CartItem;
import com.fareye.flipzone.repository.CartItemRepository;
import com.fareye.flipzone.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class CartServiceImpl implements CartService{

    @Autowired
    CartRepository cartRepository;

    @Autowired
    CartItemRepository cartItemRepository;
    @Override
    public List<Cart> getCart() {

       List<Cart>cartList=cartRepository.findAll();
       return  cartList;
    }

    @Override
    public Cart addCart( Cart cart) {

        Cart cartDB= (Cart) cartRepository.save(cart);
        return cartDB;
    }
}
