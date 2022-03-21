package com.prueba.manomano.unittest;


import com.prueba.manomano.controller.ProductController;
import com.prueba.manomano.service.ProductService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.stream.Stream;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;


@MockBean(ProductService.class)
@WebMvcTest(ProductController.class)
class ProductControllerUnitTest {

    @Autowired
    private MockMvc mockMvc;

    @ParameterizedTest
    @MethodSource("paramsForMissingParamsTest")
    @DisplayName("Should return Bad Request with no required parameters passed.")
    void shouldReturnBadRequestWithNoParams(MockHttpServletRequestBuilder request) throws Exception {
        mockMvc.perform(request).andExpect(MockMvcResultMatchers.status().isBadRequest())
                .andExpect(content().string(containsString("Missing parameter")));
    }

    private static Stream<Arguments> paramsForMissingParamsTest() {
        return Stream.of(
                Arguments.of(missingDateReq()),
                Arguments.of(missingPriceReqParam()),
                Arguments.of(missingCategoryReqParam())
        );
    }

    private static MockHttpServletRequestBuilder missingDateReq() {
        return get("/products")
                .param("categorizationId", "2")
                .param("minPrice", "50.0");
    }

    private static MockHttpServletRequestBuilder missingPriceReqParam() {
        return get("/products")
                .param("discountExpDate", "2021-08-14 02:30:00")
                .param("categorizationId", "2");
    }

    private static MockHttpServletRequestBuilder missingCategoryReqParam() {
        return get("/products")
                .param("discountExpDate", "2021-08-14 02:30:00")
                .param("minPrice", "50.0");

    }

}
