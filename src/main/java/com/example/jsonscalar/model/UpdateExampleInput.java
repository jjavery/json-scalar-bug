package com.example.jsonscalar.model;

import java.util.Map;

import lombok.Data;

@Data
public class UpdateExampleInput {
    private String id;
    private String name;
    private Map<String, Object> data;
}
