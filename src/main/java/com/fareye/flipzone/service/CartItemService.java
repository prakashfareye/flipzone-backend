package com.fareye.flipzone.service;

import com.fareye.flipzone.model.CartItem;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartItemService {
    CartItem addCartItem(CartItem cartitem);

    List<CartItem> getCartItems();

    List<CartItem> getCartItemByUserId(Long id);

    void deleteCartItemByUserId(Long id);

    void deleteCartItemByOrderId(Long id);
    List<CartItem> getCartItemByOrderId(Long id);
}
