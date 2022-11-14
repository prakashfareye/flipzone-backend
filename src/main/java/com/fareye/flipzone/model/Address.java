package com.fareye.flipzone.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Address")
public class Address {

    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "user_sequence"
    )
    @Id
    @Column(name="address_id")
    private Long Address_id;
    @Column(name="pincode")
    private String pincode;
    @Column(name="desccription")
    private String description;

}
