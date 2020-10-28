package com.viveknaskar.salonbooking.service;

import com.viveknaskar.salonbooking.domain.BookingRequest;
import com.viveknaskar.salonbooking.domain.BookingResponse;
import com.viveknaskar.salonbooking.domain.BookingSummary;
import com.viveknaskar.salonbooking.domain.UpdateBookingRequest;

import java.time.LocalDate;
import java.util.List;

public interface BookingService {

    BookingResponse bookAppointment(final BookingRequest bookingRequest);

    int deleteBooking(final String id);

    BookingResponse updateBooking(final String id, final UpdateBookingRequest request);

    BookingSummary findBookingById(final String id);

    List<LocalDate> findAvailableDays(final LocalDate from, final LocalDate to);

}
