package com.example.autoservice.dto.mapper;

import com.example.autoservice.dto.request.OrderRequestDto;
import com.example.autoservice.dto.response.OrderResponseDto;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Product;
import com.example.autoservice.model.Task;
import com.example.autoservice.service.CarService;
import com.example.autoservice.service.ProductService;
import com.example.autoservice.service.TaskService;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;

@Component
public class OrderMapper {
    private final CarService carService;
    private final TaskService taskService;
    private final ProductService productService;

    public OrderMapper(CarService carService,
                       TaskService taskService,
                       ProductService productService) {
        this.carService = carService;
        this.taskService = taskService;
        this.productService = productService;
    }

    public Order toModel(OrderRequestDto requestDto) {
        Order order = new Order();
        order.setCar(carService.findById(requestDto.getCarId()));
        order.setDescription(requestDto.getProblemDescription());
        order.setStartDate(requestDto.getStartDate());
        order.setStatus(requestDto.getStatus());
        order.setFullPrice(requestDto.getPrice());
        order.setFinishDate(requestDto.getFinishDate());
        order.setProducts(requestDto.getProductsId().stream()
                .map(productService::findById)
                .collect(Collectors.toList()));
        order.setTasks(requestDto.getTasksId()
                .stream().map(taskService::findById)
                .collect(Collectors.toList()));
        return order;
    }

    public OrderResponseDto toDto(Order order) {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
        orderResponseDto.setDescription(order.getDescription());
        orderResponseDto.setStartDate(order.getStartDate());
        orderResponseDto.setCarId(order.getCar().getId());
        orderResponseDto.setFullPrice(order.getFullPrice());
        orderResponseDto.setProductsId(order.getProducts().stream()
                .map(Product::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setTasksId(order.getTasks().stream()
                .map(Task::getId)
                .collect(Collectors.toList()));
        orderResponseDto.setStatus(order.getStatus().name());
        orderResponseDto.setFinishDate(order.getFinishDate());
        return orderResponseDto;
    }
}
