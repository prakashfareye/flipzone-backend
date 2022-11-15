package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Cart;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface CartService {
    List<Cart> getCart();

    Cart addCart(Cart cart);
}
