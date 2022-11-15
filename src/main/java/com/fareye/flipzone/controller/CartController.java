package com.fareye.flipzone.controller;

import com.fareye.flipzone.model.Cart;
import com.fareye.flipzone.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cart")
public class CartController {

    @Autowired
    CartService cartService;
    @GetMapping
    public List<Cart> getCart(){

        return cartService.getCart();

    }

    @PostMapping
    public Cart addCart(@RequestBody Cart cart){

        return cartService.addCart(cart);

    }

}
