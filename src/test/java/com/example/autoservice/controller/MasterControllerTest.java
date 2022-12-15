package com.example.autoservice.controller;

import com.example.autoservice.model.Master;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Status;
import com.example.autoservice.service.MasterService;
import io.restassured.module.mockmvc.RestAssuredMockMvc;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Collections;
import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class MasterControllerTest {
    @MockBean
    private MasterService masterService;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    private Master master;

    @BeforeEach
    void setUp() {
        RestAssuredMockMvc.mockMvc(mockMvc);
        master = new Master();
        master.setId(1L);
        master.setFullName("Peter Griffin");
        master.setCompleteOrders(Collections.emptyList());
    }

    @Test
    void mustGetSalaryById() {
        Order order = new Order();
        order.setId(1L);
        order.setFullPrice(400.0);
        order.setStatus(Status.PAID);
        master.setCompleteOrders(List.of(order));
        Mockito.when(masterService.getSalary(1L)).thenReturn(160.0);
        RestAssuredMockMvc.given()
                .queryParam("id", 1)
                .when()
                .get("/{id}/salary")
                .then()
                .statusCode(200)
                .body(Matchers.equalTo(160));
    }
}