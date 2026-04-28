package com.gym.model;

import java.time.LocalDate;

public class Payment {

    private final Member member;
    private final double amount;
    private final LocalDate date;

    public Payment(Member member, double amount, LocalDate date) {
        if (member == null) {
            throw new IllegalArgumentException("Member is required");
        }

        if (amount <= 0) {
            throw new IllegalArgumentException("Payment amount must be greater than zero");
        }

        if (date == null) {
            throw new IllegalArgumentException("Payment date is required");
        }

        this.member = member;
        this.amount = amount;
        this.date = date;
    }

    public Member getMember() {
        return member;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }
}