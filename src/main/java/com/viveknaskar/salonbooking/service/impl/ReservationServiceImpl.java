package com.viveknaskar.salonbooking.service.impl;

import com.viveknaskar.salonbooking.domain.Booking;
import com.viveknaskar.salonbooking.service.ReservationService;

import java.time.LocalDate;
import java.util.Set;

public class ReservationServiceImpl implements ReservationService {

    private static boolean isOverlapping(final Booking systemBook, final Booking userBook) {
        LocalDate dateSystem = systemBook.getBookingDate();

        LocalDate dateUser = userBook.getBookingDate();

        return ((dateSystem.isBefore(dateUser)) && (dateUser.isBefore(dateSystem)));
    }

    @Override
    public boolean checkAvailability(Set<Booking> systemBookings, Booking userBooking) {
        boolean overlaps = systemBookings
                .stream()
                .anyMatch(book -> isOverlapping(book, userBooking));

        return !overlaps;
    }
}
