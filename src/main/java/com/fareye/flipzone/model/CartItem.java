package com.fareye.flipzone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart_item")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class CartItem {
    @Id
    private Integer cartItemId;
    private Integer productId;
    private Integer cartId;
    private Integer quantity;
    private Integer price;
}
