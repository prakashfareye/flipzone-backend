package com.fareye.flipzone.repository;

import com.fareye.flipzone.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT * FROM product p WHERE p.product_name LIKE %?1%", nativeQuery = true)
    public List<Product> search(String keyword);

    @Query(value = "SELECT * FROM product p WHERE p.category_id = :categoryId", nativeQuery = true)
    public List<Product> productByCategory(long categoryId);

    @Query(value = "SELECT * FROM product p WHERE p.user_id = :id", nativeQuery = true)
    public List<Product> findByUserId(long id);

    @Query(value = "SELECT * FROM product WHERE product_id IN (SELECT product_id FROM (SELECT order_item.product_id, SUM(order_item.quantity) AS quantity_sold FROM order_item GROUP BY order_item.product_id ORDER BY  quantity_sold DESC LIMIT 5) AS foo);\n", nativeQuery = true)
    public List<Product> findTopSellingProducts();
}
