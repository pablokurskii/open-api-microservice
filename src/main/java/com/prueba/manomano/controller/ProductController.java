package com.prueba.manomano.controller;

import com.prueba.manomano.api.ProductsApi;
import com.prueba.manomano.controller.dto.ProductsIDTO;
import com.prueba.manomano.model.ProductResponseList;
import com.prueba.manomano.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.OptionalDouble;

@RestController
public class ProductController implements ProductsApi {
    public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";

    private final ProductService productsService;

    @Autowired
    public ProductController(ProductService productsService) {
        this.productsService = productsService;
    }

    @Override
    public ResponseEntity<ProductResponseList> getProducts(
            @NotNull @Valid String discountExpDate,
            @NotNull @Valid Long categorizationId,
            @Valid OptionalDouble minPrice) {
        final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS);
        final LocalDateTime dateApply = LocalDateTime.parse(discountExpDate, formatter);

        Double maxPriceValue = minPrice.orElse(0.0);

        final ProductsIDTO idto = ProductsIDTO.builder()
                .discountExpDate(dateApply)
                .categorizationId(categorizationId)
                .minPrice(maxPriceValue)
                .build();


        return ResponseEntity.ok(productsService.getProductResponse(idto));
    }
}

