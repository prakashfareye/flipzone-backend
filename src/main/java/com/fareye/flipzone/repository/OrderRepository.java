package com.fareye.flipzone.repository;

import com.fareye.flipzone.model.Order;
import com.fareye.flipzone.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {

    List<Order> findByUser_userId(Long userid);

}
