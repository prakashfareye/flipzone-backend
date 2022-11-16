package com.fareye.flipzone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name="transaction")
public class Transaction {
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "user_sequence"
    )
    @Id
    @Column(name="transaction_id")
    private Long Transaction_Id;
    @Column(name="status")
    private String Status;
    @Column(name="payment_id")
    private String paymentId;
    @Column(name="mode")
    private String mode;
    @Column(name="transaction_date")
    private Date   transactionDate;


    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="order_id")
    private Order order;

    @Column(name="user_Id")
    private Long userId;

    @Column(name="orderr_id")
    private Long orderId;

//    @ManyToOne(cascade = CascadeType.MERGE)
//    @JsonBackReference
//    @JoinColumn(name="order_id")
//    private Order  order;

}
