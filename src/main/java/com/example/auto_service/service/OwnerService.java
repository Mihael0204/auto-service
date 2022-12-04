package com.example.auto_service.service;

import com.example.auto_service.model.Order;
import com.example.auto_service.model.Owner;
import java.util.List;

public interface OwnerService {
    Owner save(Owner owner);

    Owner update(Owner owner);

    List<Order> findAllOrdersById(Long ownerId);

    Owner findById(Long id);
}
