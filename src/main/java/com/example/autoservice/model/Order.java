package com.example.autoservice.model;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Car car;
    private String description;
    private LocalDateTime startDate;
    @OneToMany(mappedBy = "order")
    private List<Task> tasks;
    @OneToMany
    private List<Product> products;
    @Enumerated(EnumType.STRING)
    private Status status;
    private double fullPrice;
    private LocalDateTime finishDate;
}
