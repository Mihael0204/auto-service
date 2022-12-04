package com.example.auto_service.dto.response;

import lombok.Data;

import java.util.List;

@Data
public class OwnerResponseDto {
    private Long id;
    private List<Long> carsId;
    private List<Long> ordersId;
}
