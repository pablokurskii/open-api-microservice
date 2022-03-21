package com.prueba.manomano.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResponseHandler {

    public static ResponseEntity<Object> generateResponseError(HttpStatus status, String title, String detail) {
        Map<String, Object> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("status", status.value());
        linkedHashMap.put("title", title);
        linkedHashMap.put("detail", detail);
        return new ResponseEntity<>(linkedHashMap, status);
    }
}
