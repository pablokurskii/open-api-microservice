package com.prueba.manomano.service.mapper;

import com.prueba.manomano.repository.entities.Product;
import com.prueba.manomano.model.ProductResponse;
import org.mapstruct.*;

import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.WARN)
public interface ProductServiceMapper {


    @IterableMapping(qualifiedByName = "entityToProductResponse")
    List<ProductResponse> getListEntityToProductResponseList(List<Product> products);

    @Named("entityToProductResponse")
    @Mapping(target = "startDate", source = "startDate", qualifiedByName = "localDateTimeToOffsetDateTime")
    @Mapping(target = "endDate", source = "endDate", qualifiedByName = "localDateTimeToOffsetDateTime")

    ProductResponse entityToProductResponse(Product product);

    @Named("localDateTimeToOffsetDateTime")
    default OffsetDateTime localDateTimeToOffsetDateTime(LocalDateTime date) {
        return date.atOffset(ZoneOffset.UTC);
    }


}
