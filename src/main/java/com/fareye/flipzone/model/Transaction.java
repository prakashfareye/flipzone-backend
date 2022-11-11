package com.fareye.flipzone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
}
