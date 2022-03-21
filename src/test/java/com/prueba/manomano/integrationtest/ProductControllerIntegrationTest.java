package com.prueba.manomano.integrationtest;


import com.prueba.manomano.ManomanoApplication;
import com.prueba.manomano.controller.ProductController;
import com.prueba.manomano.model.ProductResponseList;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = ManomanoApplication.class)
@Slf4j
class ProductControllerIntegrationTest {

    @Autowired
    private ProductController productController;


    @Test
    void contextLoads() throws Exception{
        assertThat(productController).isNotNull();
    }

    @Test
    void getProducts(){
        final String discountExpDate = "2021-04-14 00:00:00";
        final long categorizationId = 1L;
        final double minPrice = 50.0;


        final ResponseEntity<ProductResponseList> actual = productController.getProducts(discountExpDate, categorizationId, minPrice);

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        log.info("Body response {}", actual.getBody());

        assertEquals(2, Objects.requireNonNull(actual.getBody()).size());


    }

}
