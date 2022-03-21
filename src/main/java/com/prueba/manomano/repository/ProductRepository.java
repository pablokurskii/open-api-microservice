package com.prueba.manomano.repository;

import com.prueba.manomano.repository.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findAllByCategorizationType_IdAndPriceGreaterThanAndStartDateLessThanAndEndDateGreaterThan(
            Long categorizationTypeId,
            Double minPrice,
            LocalDateTime startDate,
            LocalDateTime endDate);

}
