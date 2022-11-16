package com.fareye.flipzone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order")
public class Order{
    @Id
    @SequenceGenerator(name = "order_sequence", sequenceName = "order_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "order_sequence")
    @Column(name = "order_id")
    private Long orderId;

//    @Column(name = "user_id")
//    private Long userId;

    //@JsonIgnore
    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="user_id")
    private User  user;

    //@JsonIgnore
    @OneToMany(mappedBy = "Transaction_Id",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Transaction> transactions;

    @OneToMany(mappedBy = "orderItemId",cascade = {CascadeType.ALL})
    @JsonManagedReference
    private List<OrderItem> orderItems;

    @Column(name = "status")
    private String status = "Pending";

    @Column(name = "total")
    private Double total;

    @Column(name = "address_id")
    private Long addressId;

    @Column(name = "order_date")
    private LocalDateTime orderDate = LocalDateTime.now();

}
