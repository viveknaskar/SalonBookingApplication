package com.viveknaskar.salonbooking.service;

import com.viveknaskar.salonbooking.domain.SystemBooking;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface CheckAvailabilityService {

    List<LocalDate> getAvailableDays(final Set<SystemBooking> systemBookings, final LocalDate from,
                                     final LocalDate to);
}
