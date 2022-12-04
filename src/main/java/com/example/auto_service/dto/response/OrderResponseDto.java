package com.example.auto_service.dto.response;

import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderResponseDto {
    private Long id;
    private Long carId;
    private String description;
    private LocalDateTime startDate;
    private List<Long> tasksId;
    private List<Long> productsId;
    private String status;
    private double fullPrice;
    private LocalDateTime finishDate;
}
