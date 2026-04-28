package com.gym.service;

import com.gym.model.Member;
import com.gym.model.Payment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PaymentServiceTest {

    private PaymentService paymentService;
    private Member member;

    @BeforeEach
    void setUp() {
        paymentService = new PaymentService();
        member = new Member("M001", "Laura Gomez", false);
    }

    @Test
    void shouldRegisterPaymentForMember() {
        Payment payment = paymentService.registerPayment(
                member,
                39.99,
                LocalDate.of(2026, 4, 20)
        );

        assertNotNull(payment);
        assertEquals(member, payment.getMember());
        assertEquals(39.99, payment.getAmount());
        assertEquals(LocalDate.of(2026, 4, 20), payment.getDate());
    }

    @Test
    void shouldActivateMembershipAfterPayment() {
        assertFalse(member.hasActiveMembership());

        paymentService.registerPayment(
                member,
                39.99,
                LocalDate.of(2026, 4, 20)
        );

        assertTrue(member.hasActiveMembership());
    }

    @Test
    void shouldRejectPaymentWithInvalidAmount() {
        assertThrows(
                IllegalArgumentException.class,
                () -> paymentService.registerPayment(
                        member,
                        0,
                        LocalDate.of(2026, 4, 20)
                )
        );
    }

    @Test
    void shouldReturnPaymentsForMember() {
        paymentService.registerPayment(member, 39.99, LocalDate.of(2026, 4, 20));
        paymentService.registerPayment(member, 29.99, LocalDate.of(2026, 5, 20));

        List<Payment> payments = paymentService.getPaymentsForMember(member);

        assertEquals(2, payments.size());
    }
}