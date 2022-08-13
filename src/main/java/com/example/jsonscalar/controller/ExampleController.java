package com.example.jsonscalar.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.graphql.data.method.annotation.SchemaMapping;
import org.springframework.stereotype.Controller;

import com.example.jsonscalar.model.CreateExampleInput;
import com.example.jsonscalar.model.CreateExamplePayload;
import com.example.jsonscalar.model.DeleteExampleInput;
import com.example.jsonscalar.model.DeleteExamplePayload;
import com.example.jsonscalar.model.Example;
import com.example.jsonscalar.model.UpdateExampleInput;
import com.example.jsonscalar.model.UpdateExamplePayload;

@Controller
@SchemaMapping(typeName = "Example")
public class ExampleController {
    private Integer id = 0;
    private Map<String, Example> examples = new HashMap<>();

    @QueryMapping
    public Collection<Example> examples() {
        return examples.values();
    }

    @QueryMapping
    public Example example(@Argument String id) {
        return examples.get(id);
    }

    @MutationMapping
    public CreateExamplePayload createExample(@Argument CreateExampleInput input) {
        var example = new Example((this.id++).toString(), input.getName(), input.getData());

        // Uncomment to pass test
        // var data = Map.of("foo", (Object) "bar");
        // example.setData(data);

        examples.put(example.getId(), example);

        return new CreateExamplePayload(example);
    }

    @MutationMapping
    public UpdateExamplePayload updateExample(@Argument UpdateExampleInput input) {
        var example = examples.get(input.getId());

        if (input.getName() != null) {
            example.setName(input.getName());
        }
        if (input.getData() != null) {
            example.setData(input.getData());
        }

        return new UpdateExamplePayload(example);
    }

    @MutationMapping
    public DeleteExamplePayload deleteExample(@Argument DeleteExampleInput input) {
        var example = examples.remove(input.getId());

        return new DeleteExamplePayload(example != null);
    }
}
