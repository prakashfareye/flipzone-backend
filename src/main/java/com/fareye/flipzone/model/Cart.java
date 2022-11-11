package com.fareye.flipzone.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "cart")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Cart {
    @Id
    private Integer cartId;
    private Integer userId;     //FK from user table
}
