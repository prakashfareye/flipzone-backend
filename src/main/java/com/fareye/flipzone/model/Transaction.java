package com.fareye.flipzone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
@Entity
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
    @JoinColumn(name="user_id")
    private User  user;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="order_id")
    private Order  order;

}
