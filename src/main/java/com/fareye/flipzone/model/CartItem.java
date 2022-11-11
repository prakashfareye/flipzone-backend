package com.fareye.flipzone.model;

import lombok.*;

import javax.persistence.*;

@Entity @Data
@Builder
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_item")
public class CartItem {
    @Id
    @SequenceGenerator(
            name = "cart_item_sequence",
            sequenceName = "cart_item_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "cart_item_sequence"
    )
    @Column(name = "cart_item_id")
    private long cartItemId;

    @Column(name = "product_id")
    private Integer productId;

    @Column(name = "cart_id")
    private Integer cartId;

    @Column(name = "cart_item_quantity")
    private Integer cartItemQuantity;

    @Column(name = "cart_item_price")
    private Integer cartItemPrice;
}
