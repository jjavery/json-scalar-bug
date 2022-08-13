package com.example.jsonscalar.model;

import java.util.Map;

import lombok.Data;

@Data
public class CreateExampleInput {
    private String name;
    private Map<String, Object> data;

    public Map<String, Object> getData() {
        return this.data;
    }

    public void setData(Map<String, Object> value) {
        // Interesting spot to set a breakpoint
        this.data = value;
    }
}
