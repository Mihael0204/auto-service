package com.example.autoservice.dto.response;

import lombok.Data;

@Data
public class CarResponseDto {
    private Long id;
    private String brand;
    private String model;
    private Integer yearOfRelease;
    private String number;
    private Long ownerId;
}
