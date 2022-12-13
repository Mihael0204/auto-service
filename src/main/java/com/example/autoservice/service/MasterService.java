package com.example.autoservice.service;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface MasterService {
    Master save(Master master);

    Master update(Master master);

    List<Order> getCompletedOrdersById(Long masterId);

    double getSalary(Long masterId);

    Master findById(Long id);
}
