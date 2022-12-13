package com.example.autoservice.dto.request;

import com.example.autoservice.model.Status;
import lombok.Data;

@Data
public class TaskRequestDto {
    private Long masterId;
    private double price;
    private Status status;
}
