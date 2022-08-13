package com.example.jsonscalar.model;

import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Example {
    private String id;
    private String name;
    private Map<String, Object> data;
}
