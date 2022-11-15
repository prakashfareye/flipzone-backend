package com.fareye.flipzone.dto;

import com.fareye.flipzone.model.Product;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CartItemDto {
    private long cartItemId;
    private Long userId;

    private Long cartId;

    private Long orderId;

    private Product product;

    private Long productId;


    private Integer cartItemQuantity;


    private Integer cartItemPrice;


    public CartItemDto(Long cartItemId, Long userId, Long cartId, Long orderId, Long productId, Integer cartItemQuantity, Integer cartItemPrice, Product p) {
        this.cartItemId=cartItemId;this.userId=userId;this.cartId=cartId;this.productId=productId;this.cartItemQuantity=cartItemQuantity;this.cartItemPrice=cartItemPrice;this.product=p;
    }
}
