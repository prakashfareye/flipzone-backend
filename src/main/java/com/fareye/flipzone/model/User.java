package com.fareye.flipzone.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="users",
       uniqueConstraints = @UniqueConstraint(
              name="unique_user_email_id",
               columnNames ="user_email_id"
       )
)
public class User {

    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "user_sequence"
    )
    @Id
    @Column(name="user_id")
    private Long userId;
    @NotBlank(message = "Name is mandatory")

    @Column(name="username")
    private String userName;

    @Email
    @NotBlank(message = "Email is mandatory")
    @Column(name="user_email_id")
    private String userEmailId;
    @Column
    private String password;

    @JsonIgnore
    @OneToMany(mappedBy = "orderId",cascade = CascadeType.MERGE)
    @JsonManagedReference
    private List<Order> Orders;

    @JsonIgnore
    @OneToMany(mappedBy = "Transaction_Id",cascade = CascadeType.MERGE)
    @JsonManagedReference
    private List<Transaction> Transactions;

    @JsonIgnore
    @OneToMany(mappedBy = "cartId",cascade = CascadeType.MERGE)
    @JsonManagedReference
    private List<Cart> Carts;

}
