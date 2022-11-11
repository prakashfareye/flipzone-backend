package com.fareye.flipzone.repository;

import com.fareye.flipzone.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}