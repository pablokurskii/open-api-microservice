package com.prueba.manomano.service.mapper;

import com.prueba.manomano.model.ProductResponse;
import com.prueba.manomano.repository.entities.Product;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.WARN)
public interface ProductServiceMapper {

    @IterableMapping(qualifiedByName = "entityToProductResponse")
    List<ProductResponse> getListEntityToProductResponseList(List<Product> products);

    @Named("entityToProductResponse")
    @Mapping(target = "categorizationType", source = "categorizationType.type")
    ProductResponse entityToProductResponse(Product product);
}
