package com.example.demo.Repository;

import com.example.demo.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, String> {
    List<Order> findByCustomerId(Integer customerId);
    List<Order> findByArticleId(Integer articleId);
    List<Order> findByOrderDate(Date date);

}
