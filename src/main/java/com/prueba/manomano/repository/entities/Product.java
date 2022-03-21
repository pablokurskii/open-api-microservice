package com.prueba.manomano.repository.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@Entity(name = "PRODUCTS")
public class Product {

    @Id
    @Column(name = "PRODUCT_ID")
    private Long productId;

    @Column(name = "START_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime startDate;

    @Column(name = "END_DATE")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime endDate;

    @Column(name = "PRICE")
    private Double price;

    @ManyToOne
    @JoinColumn(name = "CATEGORIZATION_ID", nullable = false)
    private CategorizationType categorizationType;

}
