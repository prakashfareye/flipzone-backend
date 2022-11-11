package com.fareye.flipzone.model;

import lombok.*;
import org.hibernate.*;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "orders")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order {
    @Id
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status")
    private String status;

    @Column(name = "total")
    private Double total;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "order_date")
    private Date orderDate;
}