package com.example.orderservice.service;

import com.example.orderservice.dto.CreateOrderResponseDTO;
import com.example.orderservice.dto.OrderRequestDto;

public interface IOrderService {

    CreateOrderResponseDTO createOrder(OrderRequestDto requestDto);
}
