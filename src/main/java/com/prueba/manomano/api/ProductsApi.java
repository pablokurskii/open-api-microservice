package com.prueba.manomano.api;

import com.prueba.manomano.model.ProductResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface ProductsApi {

    @GetMapping("/products")
    default ResponseEntity<ProductResponseList> getProducts(
            @NotNull @Valid String discountExpDate,
            @NotNull @Valid long categorizationId,
            @Valid Optional<Double> minPrice) {

        return ResponseEntity.ok(null);

    }
}
