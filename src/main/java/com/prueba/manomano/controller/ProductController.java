package com.prueba.manomano.controller;

import com.prueba.manomano.api.ProductsApi;
import com.prueba.manomano.model.ProductResponseList;
import org.springframework.http.ResponseEntity;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ProductController implements ProductsApi {

    @Override
    public ResponseEntity<ProductResponseList> getProducts(@NotNull @Valid String discountExpDate) {
        return null;
    }
}

