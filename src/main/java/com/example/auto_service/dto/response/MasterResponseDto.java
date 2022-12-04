package com.example.auto_service.dto.response;

import java.util.List;
import lombok.Data;

@Data
public class MasterResponseDto {
    private Long id;
    private String fullName;
    private List<Long> completeOrdersId;
}
