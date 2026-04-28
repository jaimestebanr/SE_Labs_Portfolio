package com.gym.model;

public class Trainer {

    private final String id;
    private final String name;

    public Trainer(String id, String name) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Trainer id is required");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Trainer name is required");
        }

        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}