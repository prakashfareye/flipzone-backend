package com.fareye.flipzone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter @Setter
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

//    @Column(name = "product_id")
//    private Integer productId;

//    @Column(name = "cart_id")
//    private Integer cartId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="cart_id")
    private Cart  cart;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="product_id")
    private Product product;

    @Column(name = "cart_item_quantity")
    private Integer cartItemQuantity;

    @Column(name = "cart_item_price")
    private Integer cartItemPrice;
}
