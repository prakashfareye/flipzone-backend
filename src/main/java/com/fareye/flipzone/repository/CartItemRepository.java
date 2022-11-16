package com.fareye.flipzone.repository;

import com.fareye.flipzone.model.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long>{

    CartItem findByCartItemId(Long id);
    List<CartItem> findByUserId(Long id);

    List<CartItem> findByOrderId(Long id);

    List<CartItem> findByCartId(Long id);

    List<CartItem> findByProductIdAndUserId(Long id,Long uid);

    @Transactional
    long deleteByUserId(Long id);
}
