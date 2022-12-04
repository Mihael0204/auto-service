package com.example.auto_service.service;

import com.example.auto_service.model.Master;
import com.example.auto_service.model.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MasterService {
    Master save(Master master);

    Master update(Master master);

    List<Order> findReadyOrder(Long orderId);

    double getSalary(Long masterId);

    Master findById(Long id);
}
