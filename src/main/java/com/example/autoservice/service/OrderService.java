package com.example.autoservice.service;

import com.example.autoservice.model.Order;
import com.example.autoservice.model.Product;
import com.example.autoservice.model.Status;

public interface OrderService {
    Order save(Order order);

    Order addProductToOrder(Long orderId, Product product);

    Order update(Order order);

    Order orderStatus(Long orderId, Status status);

    Order getOrderPrice(Long orderId);

    Order findById(Long id);
}
