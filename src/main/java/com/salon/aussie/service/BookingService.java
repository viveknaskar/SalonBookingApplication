package com.salon.aussie.service;

import com.salon.aussie.domain.Booking;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface BookingService {

    Booking createBookingService(Booking bookingDetails);
    List<Booking> getAllBookingServices();
    List<Booking> getAllBookingServicesForAdmin();
    boolean getBarberAvailability(Booking bookingDetails);
    List<Booking> getBookingOfBarber(long id);
}
