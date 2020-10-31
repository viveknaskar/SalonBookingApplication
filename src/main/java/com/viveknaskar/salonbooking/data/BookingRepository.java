package com.viveknaskar.salonbooking.data;

import com.viveknaskar.salonbooking.domain.Booking;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingRepository extends MongoRepository<Booking, String> {
}
