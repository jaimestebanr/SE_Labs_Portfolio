package com.gym.service;

import com.gym.model.Booking;
import com.gym.model.GymClass;
import com.gym.model.Member;

public class BookingService {

    public Booking bookClass(Member member, GymClass gymClass) {
        if (member == null) {
            throw new IllegalArgumentException("Member is required");
        }

        if (gymClass == null) {
            throw new IllegalArgumentException("Gym class is required");
        }

        if (!member.hasActiveMembership()) {
            throw new IllegalStateException("Member does not have an active membership");
        }

        if (!gymClass.hasAvailablePlaces()) {
            throw new IllegalStateException("Class is full");
        }

        gymClass.reservePlace();

        return new Booking(member, gymClass);
    }

    public void recordAttendance(Booking booking) {
        if (booking == null) {
            throw new IllegalArgumentException("Booking is required");
        }

        booking.markAttendance();
    }
}