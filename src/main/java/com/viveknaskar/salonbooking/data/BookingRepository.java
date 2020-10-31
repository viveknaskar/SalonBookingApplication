package com.viveknaskar.salonbooking.data;

import com.viveknaskar.salonbooking.domain.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.time.LocalDate;
import java.util.List;

public interface BookingRepository extends MongoRepository<Booking, String> {
    List<Booking> findByBookingDate(LocalDate bookingDate);
    List<Booking> findByBookingId(String id);
    List<Booking> findByBookingConfirmed(boolean bookingConfirmed);
}
