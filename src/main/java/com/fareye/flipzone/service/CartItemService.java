package com.fareye.flipzone.service;

import com.fareye.flipzone.dto.CartItemDto;
import com.fareye.flipzone.model.CartItem;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CartItemService {

    CartItem getCartItemByCartItemtId(Long id);
    CartItem addCartItem(CartItem cartitem);

    List<CartItem> getCartItems();

    List<CartItemDto> getCartItemByUserId(Long id);

    void deleteCartItemByUserId(Long id);

    void deleteCartItemByOrderId(Long id);
    List<CartItem> getCartItemByOrderId(Long id);
    List<CartItem> getCartItemByCartId(Long id);

    CartItem updateCartItem(Long id, CartItem cartItem, Integer add);
}
