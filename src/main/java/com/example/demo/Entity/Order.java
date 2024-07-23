package com.example.demo.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@Entity(name = "my_order")
public class Order {
    @Id
    private String orderId;
    @Column
    private Integer customerId;
    @Column
    private Integer count;
    @Column
    private Integer articleId;
    @Column
    private Date orderDate;

    public Order(String orderId, Integer customerId, Integer count, Integer articleId, Date orderDate) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.count = count;
        this.articleId = articleId;
        this.orderDate = orderDate != null ? orderDate : Date.valueOf(LocalDate.now());
    }

    public Order(String orderId, Integer customerId, Integer count, Integer articleId) {
        this(orderId, customerId, count, articleId, null);
    }

    public Order() {
    }

    @Override
    public String toString() {
        return orderId + " " + customerId + " " + count + " " + articleId + " " + orderDate;
    }

}