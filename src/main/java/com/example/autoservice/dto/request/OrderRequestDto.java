package com.example.autoservice.dto.request;

import com.example.autoservice.model.Status;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;

@Data
public class OrderRequestDto {
    private Long carId;
    private String problemDescription;
    private LocalDateTime startDate;
    private List<Long> tasksId;
    private List<Long> productsId;
    private Status status;
    private double price;
    private LocalDateTime finishDate;
}
