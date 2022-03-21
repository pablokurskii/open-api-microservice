package com.prueba.manomano.service;

import com.prueba.manomano.controller.dto.ProductsIDTO;
import com.prueba.manomano.model.ProductResponseList;

public interface ProductService {
    ProductResponseList getProductResponse(ProductsIDTO request);
}
