package com.example.jsonscalar.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

@SpringBootTest
@AutoConfigureGraphQlTester
public class ExampleControllerTests {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void shouldCreateExample() {
        var data = Map.of("foo", (Object) "bar");

        var input = Map.of(
                "name", "test",
                "data", data);

        graphQlTester.documentName("create-example")
                .variable("input", input)
                .execute()
                .path("createExample.example.data.foo")
                .entity(String.class)
                .isEqualTo("bar");
    }
}
