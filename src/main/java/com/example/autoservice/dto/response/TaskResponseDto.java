package com.example.autoservice.dto.response;

import lombok.Data;

@Data
public class TaskResponseDto {
    private Long id;
    private Long masterId;
    private double price;
    private String status;
}
