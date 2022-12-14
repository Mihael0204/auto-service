package com.example.autoservice.dto.request;

import lombok.Data;

@Data
public class CarRequestDto {
    private String brand;
    private String model;
    private Integer yearOfRelease;
    private String number;
    private Long ownerId;
}
