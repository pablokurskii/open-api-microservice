package com.prueba.manomano.api;

import com.prueba.manomano.model.ProductResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Optional;

public interface ProductsApi {

    @GetMapping("/products")
    default ResponseEntity<ProductResponseList> getProducts(
            @RequestParam @NotNull @Valid String discountExpDate,
            @RequestParam @NotNull @Valid Long categorizationId,
            @RequestParam @Valid Double minPrice) {

        return ResponseEntity.ok(null);

    }
}
