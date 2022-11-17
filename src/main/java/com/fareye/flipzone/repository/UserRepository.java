package com.fareye.flipzone.repository;

import com.fareye.flipzone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    // userEmailId
    User findByUserEmailId(String email);

    @Query(value = "select * from users where users.user_id in (select x.user_id from product inner join (SELECT * FROM public.\"order\" inner join order_item on public.\"order\".order_id = order_item.order_id ) as x on product.product_id =x.product_id where product.user_id=:id)",nativeQuery = true)
    List<User> findUserForProduct(@Param("id") Long id);


}
