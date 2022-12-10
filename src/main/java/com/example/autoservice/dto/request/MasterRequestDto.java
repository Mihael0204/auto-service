package com.example.autoservice.dto.request;

import java.util.List;
import lombok.Data;

@Data
public class MasterRequestDto {
    private String fullName;
    private List<Long> completedOrdersId;
}
