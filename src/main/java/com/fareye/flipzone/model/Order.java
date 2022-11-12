package com.fareye.flipzone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_sequence")
    @Column(name = "order_id")
    private Long orderId;

//    @Column(name = "user_id")
//    private Long userId;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User  user;

    @JsonIgnore
    @OneToMany(mappedBy = "Transaction_Id",cascade = CascadeType.MERGE)
    @JsonManagedReference
    private List<Transaction> transactions;


    @Column(name = "status")
    private String status = "Pending";

    @Column(name = "total")
    private Double total;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "order_date")
    private LocalDateTime orderDate = LocalDateTime.now();
}
