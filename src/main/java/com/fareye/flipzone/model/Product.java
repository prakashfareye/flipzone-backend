package com.fareye.flipzone.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class Product {
    @Id
    private Integer productId;
    private Integer productCategoryId;      //foreign key (prod_cat table)
    private String productName;
    private Integer userId;         //foreign key used from user table
    private Integer price;
    private String productDescription;
    private Integer quantity;
    private String imageURL;
}
