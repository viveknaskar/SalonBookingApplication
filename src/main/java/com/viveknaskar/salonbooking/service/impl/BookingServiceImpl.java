package com.viveknaskar.salonbooking.service.impl;

import com.viveknaskar.salonbooking.domain.BookingRequest;
import com.viveknaskar.salonbooking.domain.BookingResponse;
import com.viveknaskar.salonbooking.domain.BookingSummary;
import com.viveknaskar.salonbooking.domain.UpdateBookingRequest;
import com.viveknaskar.salonbooking.service.BookingService;

import java.time.LocalDate;
import java.util.List;

public class BookingServiceImpl implements BookingService {
    @Override
    public BookingResponse bookAppointment(BookingRequest bookingRequest) {
        return null;
    }

    @Override
    public int deleteBooking(String id) {
        return 0;
    }

    @Override
    public BookingResponse updateBooking(String id, UpdateBookingRequest request) {
        return null;
    }

    @Override
    public BookingSummary findBookingById(String id) {
        return null;
    }

    @Override
    public List<LocalDate> findAvailableDays(LocalDate from, LocalDate to) {
        return null;
    }
}
