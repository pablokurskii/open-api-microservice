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

        String expectedBody = "class ProductResponseList {\n" +
                "    products: [class ProductResponse {\n" +
                "        productId: 13\n" +
                "        startDate: 2021-03-14T02:00Z\n" +
                "        endDate: 2021-09-14T03:00Z\n" +
                "        price: 78.87\n" +
                "        categorizationType: B2B\n" +
                "        description: Business-to-Business\n" +
                "    }, class ProductResponse {\n" +
                "        productId: 14\n" +
                "        startDate: 2021-03-14T02:00Z\n" +
                "        endDate: 2021-09-14T03:00Z\n" +
                "        price: 92.41\n" +
                "        categorizationType: B2B\n" +
                "        description: Business-to-Business\n" +
                "    }]\n" +
                "}";

        assertThat(actual.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(actual.getBody()).isNotNull();
        assertThat(actual.getBody()).hasToString(expectedBody);

    }
}
