package com.prueba.manomano.model;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ProductResponseList extends LinkedHashMap<String, List<ProductResponse>> {
    public List<ProductResponse> getValues(){
        Map.Entry<String, List<ProductResponse>> next = this.entrySet().iterator().next();
        return next.getValue();
    }

    @Override
    public int size() {
        return getValues().size();
    }

    @Override
    public String toString() {
        return getValues().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(",", "{", "}"));
    }
}
