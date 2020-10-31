package com.viveknaskar.salonbooking.service;

import com.viveknaskar.salonbooking.domain.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    Booking createBookingService(Booking bookingDetails);
    List<Booking> getAllBookingServices();
    boolean getBarberAvailability(Booking bookingDetails);
}
