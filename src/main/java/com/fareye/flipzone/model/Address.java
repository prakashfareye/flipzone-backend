package com.fareye.flipzone.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Table(name="Address")
public class Address {

    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "user_sequence"
    )
    @Column(name="address_id")
    private Long Address_id;
    @Column(name="pincode")
    private String pincode;
    @Column(name="desccription")
    private String description;

}
