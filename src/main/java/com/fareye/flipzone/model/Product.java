package com.fareye.flipzone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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

//    @Column(name = "product_category_id")
//    private Integer productCategoryId;      //foreign key (prod_cat table)

    @ManyToOne(cascade = CascadeType.MERGE)
    @JsonBackReference
    @JoinColumn(name="product_category_id")
    private ProductCategory  productCategory;


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

//    @JsonIgnore
//    @OneToMany(mappedBy = "cartItemId;",cascade = CascadeType.MERGE)
//    @JsonManagedReference
//    private List<CartItem> CartItems;

    @JsonIgnore
    @OneToMany(mappedBy = "cartItemId",cascade = CascadeType.MERGE)
    @JsonManagedReference
    private List<CartItem> cartItems;

}
