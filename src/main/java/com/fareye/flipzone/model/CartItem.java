package com.fareye.flipzone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "cart_id")
    private Long cartId;


    @Column(name = "order_id")
    private Long orderId;

//    @JsonIgnore
//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JsonBackReference
//    @JoinColumn(name="product_id")
//    private Product product;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "cart_item_quantity")
    private Integer cartItemQuantity;

    @Column(name = "cart_item_price")
    private Integer cartItemPrice;

}
