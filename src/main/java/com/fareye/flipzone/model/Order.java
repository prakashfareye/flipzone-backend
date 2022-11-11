package com.fareye.flipzone.model;

import lombok.*;

import javax.persistence.*;
import java.time.*;

@Entity
@Getter @Setter @ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Order {
    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_sequence")
    @Column(name = "order_id")
    private Long orderId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "status")
    private String status = "Pending";

    @Column(name = "total")
    private Double total;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "order_date")
    private LocalDateTime orderDate = LocalDateTime.now();
}