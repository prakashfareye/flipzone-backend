package com.fareye.flipzone.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Address")
public class Address {
    @Id
    @SequenceGenerator(
            name = "address_sequence",
            sequenceName = "address_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "address_sequence"
    )
    @Column(name="address_id")
    private Long address_id;
    @Column(name="pin_code")
    private String pinCode;
    @Column(name="description")
    private String description;
    @Column(name = "user_id")
    private long userId;

}
