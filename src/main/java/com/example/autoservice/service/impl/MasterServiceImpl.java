package com.example.autoservice.service.impl;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Status;
import com.example.autoservice.repository.MasterRepository;
import com.example.autoservice.service.MasterService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class MasterServiceImpl implements MasterService {
    private static final double MASTERS_SALARY_PERCENT = 0.4;
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
    public List<Order> getCompletedOrdersById(Long masterId) {
        return findById(masterId).getCompleteOrders();
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
        return result * MASTERS_SALARY_PERCENT;
    }

    @Override
    public Master findById(Long id) {
        return repository.findById(id).orElseThrow(()
                -> new RuntimeException("Can't find master by id " + id));
    }
}
