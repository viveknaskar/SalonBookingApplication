package com.viveknaskar.salonbooking.service;

import com.viveknaskar.salonbooking.domain.*;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    BookingResponse bookAppointment(final Booking booking);

    int deleteBooking(final String id);

    BookingResponse updateBooking(final String id, final UpdateBookingRequest request);

    BookingSummary findBookingById(final String id);

    List<LocalDate> findAvailableDays(final LocalDate from, final LocalDate to);

}
