package com.gym.service;

import com.gym.model.Booking;
import com.gym.model.GymClass;
import com.gym.model.Member;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class BookingServiceTest {

    private BookingService bookingService;
    private Member activeMember;
    private GymClass yogaClass;

    @BeforeEach
    void setUp() {
        bookingService = new BookingService();
        activeMember = new Member("M001", "Laura Gomez", true);
        yogaClass = new GymClass(
                "C001",
                "Yoga",
                LocalDateTime.of(2026, 4, 20, 10, 0),
                LocalDateTime.of(2026, 4, 20, 11, 0),
                2
        );
    }

    @Test
    void shouldBookClassWhenMemberHasActiveMembershipAndPlacesAreAvailable() {
        Booking booking = bookingService.bookClass(activeMember, yogaClass);

        assertNotNull(booking);
        assertEquals(activeMember, booking.getMember());
        assertEquals(yogaClass, booking.getGymClass());
        assertEquals(1, yogaClass.getBookedPlaces());
        assertEquals(1, yogaClass.getAvailablePlaces());
    }

    @Test
    void shouldRejectBookingWhenMemberMembershipIsInactive() {
        Member inactiveMember = new Member("M002", "Carlos Ruiz", false);

        assertThrows(
                IllegalStateException.class,
                () -> bookingService.bookClass(inactiveMember, yogaClass)
        );

        assertEquals(0, yogaClass.getBookedPlaces());
    }

    @Test
    void shouldRejectBookingWhenClassIsFull() {
        Member secondMember = new Member("M002", "Carlos Ruiz", true);
        Member thirdMember = new Member("M003", "Ana Martin", true);

        bookingService.bookClass(activeMember, yogaClass);
        bookingService.bookClass(secondMember, yogaClass);

        assertThrows(
                IllegalStateException.class,
                () -> bookingService.bookClass(thirdMember, yogaClass)
        );

        assertEquals(2, yogaClass.getBookedPlaces());
        assertEquals(0, yogaClass.getAvailablePlaces());
    }

    @Test
    void shouldRecordAttendanceForABooking() {
        Booking booking = bookingService.bookClass(activeMember, yogaClass);

        bookingService.recordAttendance(booking);

        assertTrue(booking.hasAttended());
    }
}