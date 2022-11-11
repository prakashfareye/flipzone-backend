package com.fareye.flipzone.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "prod_cat")
@Setter
@Getter
@NoArgsConstructor
@ToString
public class ProductCategory {
    @Id
    private Integer productCategoryId;
    private String productCategoryName;
    private String productCategoryImageURL;
}
