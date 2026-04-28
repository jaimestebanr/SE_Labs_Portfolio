package com.gym.model;

import java.time.LocalDateTime;

public class GymClass {

    private final String id;
    private final String name;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    private final int capacity;
    private Trainer trainer;
    private int bookedPlaces;

    public GymClass(String id, String name, LocalDateTime startTime, LocalDateTime endTime, int capacity) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("Class id is required");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Class name is required");
        }

        if (startTime == null || endTime == null) {
            throw new IllegalArgumentException("Class schedule is required");
        }

        if (!endTime.isAfter(startTime)) {
            throw new IllegalArgumentException("End time must be after start time");
        }

        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be greater than zero");
        }

        this.id = id;
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
        this.capacity = capacity;
        this.bookedPlaces = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public int getCapacity() {
        return capacity;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public void assignTrainer(Trainer trainer) {
        if (trainer == null) {
            throw new IllegalArgumentException("Trainer is required");
        }

        this.trainer = trainer;
    }

    public int getBookedPlaces() {
        return bookedPlaces;
    }

    public int getAvailablePlaces() {
        return capacity - bookedPlaces;
    }

    public boolean hasAvailablePlaces() {
        return bookedPlaces < capacity;
    }

    public void reservePlace() {
        if (!hasAvailablePlaces()) {
            throw new IllegalStateException("Class is full");
        }

        bookedPlaces++;
    }

    public boolean overlapsWith(GymClass other) {
        return startTime.isBefore(other.endTime) && endTime.isAfter(other.startTime);
    }
}