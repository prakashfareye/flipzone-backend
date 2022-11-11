package com.fareye.flipzone.model;

import lombok.*;

import javax.persistence.*;

@Entity @Data
@Builder
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart")
public class Cart {
    @Id
    @SequenceGenerator(
            name = "cart_sequence",
            sequenceName = "cart_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "cart_sequence"
    )
    @Column(name = "cart_id")
    private long cartId;

    @Column(name = "user_id")
    private Integer userId;     //FK from user table
}
