package com.gym.model;

public class Member {

    private final String id;
    private final String name;
    private boolean activeMembership;

    public Member(String id, String name, boolean activeMembership) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Member id is required");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Member name is required");
        }

        this.id = id;
        this.name = name;
        this.activeMembership = activeMembership;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public boolean hasActiveMembership() {
        return activeMembership;
    }

    public void activateMembership() {
        this.activeMembership = true;
    }

    public void expireMembership() {
        this.activeMembership = false;
    }
}