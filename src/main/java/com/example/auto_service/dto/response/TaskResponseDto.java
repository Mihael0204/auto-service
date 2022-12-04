package com.example.auto_service.dto.response;

import lombok.Data;

@Data
public class TaskResponseDto {
    private Long id;
    private Long orderId;
    private Long masterId;
    private double price;
    private String status;
}
