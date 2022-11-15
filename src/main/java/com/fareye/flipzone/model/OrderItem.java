package com.fareye.flipzone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_item")
public class OrderItem  {
    @Id
    @SequenceGenerator(name = "order_item_sequence", sequenceName = "order_item_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_item_sequence")
    @Column(name = "order_item_id")
    private Long orderItemId;

    @Column(name = "product_id")
    private Long productId;

//    @Column(name = "order_id")
//    private Long orderId;

    @ManyToOne(cascade ={CascadeType.MERGE})
    @JsonBackReference
    @JoinColumn(name="order_id")
    private Order  order;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "total")
    private Double total;

}
