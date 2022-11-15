package com.fareye.flipzone.dto;

import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.Product;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemDto {

    private Long orderItemId;

    private Product product;

    private Integer quantity;

    private Double total;

    public OrderItemDto(Product p, Integer quantity, Double total) {
        this.product=p;
        this.quantity=quantity;
        this.total=total;
    }
}
