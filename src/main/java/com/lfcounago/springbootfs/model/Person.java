package com.lfcounago.springbootfs.model;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Person {

    private final UUID id;
    @NotBlank(message = "Name must not be blank")
    private final String name;

    public Person(@JsonProperty("id") UUID id, @JsonProperty("name") @NotBlank String name) {
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
