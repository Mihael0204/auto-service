package com.example.autoservice.service.impl;

import com.example.autoservice.model.Order;
import com.example.autoservice.model.Product;
import com.example.autoservice.model.Status;
import com.example.autoservice.model.Task;
import com.example.autoservice.repository.OrderRepository;
import com.example.autoservice.service.OrderService;
import com.example.autoservice.service.OwnerService;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {
    private static final int DIAGNOSTICS_PRICE = 500;
    private final OrderRepository orderRepository;
    private final OwnerService ownerService;

    public OrderServiceImpl(OrderRepository orderRepository,
                            OwnerService ownerService) {
        this.orderRepository = orderRepository;
        this.ownerService = ownerService;
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order addProductToOrder(Long orderId, Product product) {
        Order order = findById(orderId);
        order.setProducts(List.of(product));
        return order;
    }

    @Override
    public Order update(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order orderStatus(Long orderId, Status status) {
        Order order = findById(orderId);
        order.setStatus(status);
        order.setFinishDate(LocalDateTime.now());
        return order;
    }

    @Override
    public Order getOrderPrice(Long orderId) {
        Order order = findById(orderId);
        List<Task> tasks = findById(orderId).getTasks();
        List<Product> products = findById(orderId).getProducts();
        double countTasks = tasks.size() == 1 ? DIAGNOSTICS_PRICE : tasks.stream()
                .mapToDouble(Task::getPrice).sum();
        double countProducts = products.stream().mapToDouble(Product::getPrice).sum();
        order.setFullPrice((countTasks * (100 - (ownerService
                        .findAllOrdersById(orderRepository
                                .findById(orderId).get().getCar().getOwner().getId()).size() * 2)))
                + (countProducts * (100 - ownerService
                        .findAllOrdersById(orderRepository
                                .findById(orderId).get().getCar().getOwner().getId()).size())));
        return order;
    }

    @Override
    public Order findById(Long id) {
        return orderRepository.findById(id).orElseThrow(()
                -> new RuntimeException("Can't find order by id " + id));
    }
}
