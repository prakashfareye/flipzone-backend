package com.fareye.flipzone.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity @Data @Builder
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "product_category")
public class ProductCategory {
    @Id
    @SequenceGenerator(
            name = "product_category_sequence",
            sequenceName = "product_category_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "product_category_sequence"
    )
    @Column(name = "product_category_id")
    private long productCategoryId;

    @NotBlank(message = "Product Category Name cannot be blank")
    @Column(
            name = "product_category_name",
            nullable = false
    )
    private String productCategoryName;

    @Column(name = "product_category_image_url")
    private String productCategoryImageURL;
}
