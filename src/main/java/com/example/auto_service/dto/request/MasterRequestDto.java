package com.example.auto_service.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class MasterRequestDto {
    private String fullName;
    private List<Long> completedOrdersId;
}
