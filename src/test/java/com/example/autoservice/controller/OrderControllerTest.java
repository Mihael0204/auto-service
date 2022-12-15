package com.example.autoservice.controller;

import com.example.autoservice.model.Car;
import com.example.autoservice.model.Order;
import com.example.autoservice.model.Status;
import com.example.autoservice.service.OrderService;
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

import java.time.LocalDateTime;
import java.util.Collections;

@SpringBootTest
@AutoConfigureMockMvc
@ExtendWith(SpringExtension.class)
class OrderControllerTest {
    @MockBean
    private OrderService orderService;
    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private MockMvc mockMvc;
    private Order order;

    @BeforeEach
    void setUp() {
        order = new Order();
        order.setId(1L);
        order.setStatus(Status.ACCEPTED);
        order.setCar(new Car());
        order.setDescription("diagnostics");
        order.setFullPrice(500.0);
        order.setStartDate(LocalDateTime.of(2022, 12, 13, 11, 20));
        order.setFinishDate(LocalDateTime.of(2022, 12, 13, 14, 20));
        order.setProducts(Collections.emptyList());
        order.setTasks(Collections.emptyList());
    }

    @Test
    void getOrderPrice() {
        Mockito.when(orderService.getOrderPrice(1L))
                .thenReturn(order);
        RestAssuredMockMvc.given()
                .queryParam("id", 1)
                .when()
                .get("/{id}/price")
                .then()
                .statusCode(200)
                .body("price", Matchers.equalTo(500));
    }
}