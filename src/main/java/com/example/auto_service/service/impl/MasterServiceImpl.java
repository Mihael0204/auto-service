package com.example.auto_service.service.impl;

import com.example.auto_service.model.Master;
import com.example.auto_service.model.Order;
import com.example.auto_service.model.Status;
import com.example.auto_service.repository.MasterRepository;
import com.example.auto_service.service.MasterService;

import java.math.BigDecimal;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    private final MasterRepository repository;

    public MasterServiceImpl(MasterRepository repository) {
        this.repository = repository;
    }


    @Override
    public Master save(Master master) {
        return repository.save(master);
    }

    @Override
    public Master update(Master master) {
        return repository.save(master);
    }

    @Override
    public List<Order> findReadyOrder(Long orderId) {
        return findById(orderId).getCompleteOrders();
    }

    @Override
    public double getSalary(Long masterId) {
        Master master = findById(masterId);
        List<Order> orders = master.getCompleteOrders();
        double result = 0.0;
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).getStatus() != Status.PAID) {
                result += orders.get(i).getFullPrice();
                orders.get(i).setStatus(Status.PAID);
            }
        }
        return result * 0.4;
    }

    @Override
    public Master findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can't find master by id " + id));
    }
}
