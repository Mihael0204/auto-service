package com.example.auto_service.dto.request;

import com.example.auto_service.model.Status;
import lombok.Data;

@Data
public class TaskRequestDto {
    private Long orderId;
    private Long masterId;
    private double price;
    private Status status;
}
