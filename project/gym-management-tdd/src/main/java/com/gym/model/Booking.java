package com.gym.model;

public class Booking {

    private final Member member;
    private final GymClass gymClass;
    private boolean attended;

    public Booking(Member member, GymClass gymClass) {
        if (member == null) {
            throw new IllegalArgumentException("Member is required");
        }

        if (gymClass == null) {
            throw new IllegalArgumentException("Gym class is required");
        }

        this.member = member;
        this.gymClass = gymClass;
        this.attended = false;
    }

    public Member getMember() {
        return member;
    }

    public GymClass getGymClass() {
        return gymClass;
    }

    public boolean hasAttended() {
        return attended;
    }

    public void markAttendance() {
        attended = true;
    }
}