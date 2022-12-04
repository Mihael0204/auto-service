package com.example.auto_service.service;

import com.example.auto_service.model.Order;
import com.example.auto_service.model.Product;
import com.example.auto_service.model.Status;

public interface OrderService {
    Order save(Order order);

    Order addProductToOrder(Long orderId, Product product);

    Order update(Order order);

    Order orderStatus(Long orderId, Status status);

    Order getOrderPrice(Long orderId);

    Order findById(Long id);
}
