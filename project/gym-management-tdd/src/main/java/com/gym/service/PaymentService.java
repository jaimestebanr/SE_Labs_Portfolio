package com.gym.service;

import com.gym.model.Member;
import com.gym.model.Payment;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PaymentService {

    private final List<Payment> payments = new ArrayList<>();

    public Payment registerPayment(Member member, double amount, LocalDate date) {
        Payment payment = new Payment(member, amount, date);
        payments.add(payment);
        member.activateMembership();
        return payment;
    }

    public List<Payment> getPaymentsForMember(Member member) {
        List<Payment> result = new ArrayList<>();

        for (Payment payment : payments) {
            if (payment.getMember().getId().equals(member.getId())) {
                result.add(payment);
            }
        }

        return result;
    }
}