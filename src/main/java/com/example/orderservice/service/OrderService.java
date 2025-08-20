package com.example.orderservice.service;

import com.example.orderservice.clients.ProductServiceClient;
import com.example.orderservice.dto.CreateOrderResponseDTO;
import com.example.orderservice.dto.OrderItemDTO;
import com.example.orderservice.dto.OrderRequestDto;
import com.example.orderservice.dto.ProductDTO;
import com.example.orderservice.entity.Order;
import com.example.orderservice.entity.OrderItem;
import com.example.orderservice.mapper.OrderItemMapper;
import com.example.orderservice.mapper.OrderMapper;
import com.example.orderservice.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    private final OrderRepository orderRepository;
    private final ProductServiceClient productClient;
    public OrderService(OrderRepository orderRepository, ProductServiceClient productClient) {
        this.orderRepository = orderRepository;
        this.productClient = productClient;
    }


    @Override
    public CreateOrderResponseDTO createOrder(OrderRequestDto request) {

        //persist the order in order table >> orderRequestDTO > order Entity
        Order order =OrderMapper.toEntity(request);

        List<OrderItem>items=new ArrayList<OrderItem>();

        for(OrderItemDTO itemDTO : request.getItems()) {
            // fetch the product details for every item
            ProductDTO product = productClient.getProductById(itemDTO.getProductId());
            double pricePerUnit = product.getPrice();
            double totalPrice = product.getPrice() * itemDTO.getQuantity();
            OrderItem item = OrderItemMapper.OrderItemRequestDTOtoOrderItemEntity(
                itemDTO,
                    order,
                    pricePerUnit,
                    totalPrice
            );
            items.add(item);
        }

        order.setItems(items);
        Order createdOrder= orderRepository.save(order);
        return  OrderMapper.toCreateOrderResponseDTO(createdOrder);
    }
}
