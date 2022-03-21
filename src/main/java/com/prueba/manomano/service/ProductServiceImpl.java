package com.prueba.manomano.service;

import com.prueba.manomano.controller.dto.ProductsIDTO;
import com.prueba.manomano.model.ProductResponse;
import com.prueba.manomano.model.ProductResponseList;
import com.prueba.manomano.repository.ProductRepository;
import com.prueba.manomano.repository.entities.Product;
import com.prueba.manomano.service.mapper.ProductServiceMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final ProductServiceMapper productServiceMapper;


    public ProductResponseList getProductResponse(final ProductsIDTO request) {
        final LocalDateTime discountExpDate = request.getDiscountExpDate();
        final List<Product> products = productRepository
                .findAllByCategorizationType_IdAndPriceGreaterThanAndStartDateLessThanAndEndDateGreaterThan(
                        request.getCategorizationId(),
                        request.getMinPrice(),
                        discountExpDate,
                        discountExpDate);

        return new ProductResponseList()
                .products(productServiceMapper.getListEntityToProductResponseList(products));
    }
}
