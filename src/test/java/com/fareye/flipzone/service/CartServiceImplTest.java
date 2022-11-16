package com.fareye.flipzone.service;

import com.fareye.flipzone.model.Cart;
import com.fareye.flipzone.repository.CartRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CartServiceImplTest {
    @Mock
    private CartRepository cartRepository;
    @InjectMocks
    CartServiceImpl cartService;

    private Cart cart;

    @BeforeEach
    public void setup(){
        long id=2;
        cart = Cart.builder()
                .cartId(id)
                .build();
    }

    @DisplayName("JUnit Test for add cart")
    @Test
    public void addCartTest() {

        when(cartRepository.save(cart)).thenReturn(cart);
        assertEquals(cart, cartService.addCart(cart));

    }

    @DisplayName("JUnit Test for getting carts from DB")
    @Test
    public void getCart() {
        List<Cart> cartList = new ArrayList<>();
        cartList.add(cart);
        when(cartRepository.findAll()).thenReturn(cartList);
        assertEquals(1, cartService.getCart().size());
    }

}