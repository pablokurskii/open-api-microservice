package com.prueba.manomano.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@ToString
public class ProductResponse {
    private Long productId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Double price;
    private String categorizationType;
}
