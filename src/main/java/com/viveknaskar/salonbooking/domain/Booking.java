package com.viveknaskar.salonbooking.domain;

import java.time.LocalDate;

public class Booking {
    private final String id;

    public String getId() {
        return id;
    }

    public LocalDate getBookingDate() {
        return bookingDate;
    }

    private final LocalDate bookingDate;

    public Booking(String id, LocalDate bookingDate) {
        this.id = id;
        this.bookingDate = bookingDate;
    }

}
