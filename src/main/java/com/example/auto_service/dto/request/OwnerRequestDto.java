package com.example.auto_service.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class OwnerRequestDto {
    private List<Long> carsId;
    private List<Long> ordersId;
}
