package com.viveknaskar.salonbooking.service;

import com.viveknaskar.salonbooking.domain.Booking;

import java.util.Set;

public interface ReservationService {

    boolean checkAvailability(final Set<Booking> systemBookings, final Booking userBooking);
}
