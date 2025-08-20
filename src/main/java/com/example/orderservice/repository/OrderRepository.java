package com.example.orderservice.repository;

import com.example.orderservice.entity.Order;
import com.example.orderservice.service.IOrderService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Order, Long> {

}
