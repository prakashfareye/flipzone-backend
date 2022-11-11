package com.fareye.flipzone.model;

import lombok.*;

import javax.persistence.*;

@Entity @Data @Builder
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product")
public class Product {
    @Id
    @SequenceGenerator(
            name = "product_sequence",
            sequenceName = "product_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "product_sequence"
    )
    @Column(name = "product_id")
    private long productId;

    @Column(name = "product_category_id")
    private Integer productCategoryId;      //foreign key (prod_cat table)

    @Column(name = "product_name")
    private String productName;

    @Column(name = "user_id")
    private Integer userId;         //foreign key used from user table

    @Column(name = "product_price")
    private Integer productPrice;

    @Column(name = "product_description")
    private String productDescription;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    @Column(name = "product_image_url")
    private String productImageURL;
}
