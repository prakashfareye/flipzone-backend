package com.fareye.flipzone.model;

import lombok.*;
import org.hibernate.*;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class OrderItem {
    @Id
    @Column(name = "order_item_id")
    private Long orderItemId;

    @Column(name = "product_id")
    private Long productId;

    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total")
    private Double total;
}
