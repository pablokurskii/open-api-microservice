package com.prueba.manomano.api;

import com.prueba.manomano.model.ProductResponseList;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.format.DateTimeFormatter;
import java.util.OptionalDouble;

@RequestMapping("/products")
public interface ProductsApi {

    @GetMapping("/")
    default ResponseEntity<ProductResponseList> getProducts(@RequestParam @NotNull @Valid String discountExpDate,
                                                            @RequestParam @NotNull @Valid Long categoryId,
                                                            @RequestParam @Valid OptionalDouble minPrice) {
        /*TODO */
        return null;
    }
}
