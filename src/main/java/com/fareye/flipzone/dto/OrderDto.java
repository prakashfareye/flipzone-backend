package com.fareye.flipzone.dto;


import com.fareye.flipzone.model.OrderItem;
import com.fareye.flipzone.model.User;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderDto {
    private Long orderId;

    private List<OrderItemDto> orderItemsDto;

    private String status ;

    private Double total;

    private Long addressId;

    private LocalDateTime orderDate;

}
