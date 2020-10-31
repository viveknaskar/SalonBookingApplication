package com.viveknaskar.salonbooking.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document(collection = "booking")
public class Booking {
    @Id
    private String id;

    private LocalDate bookingDate;

    private boolean bookingConfirmed;


    public Booking(String id, LocalDate bookingDate, boolean bookingConfirmed) {
        this.id = id;
        this.bookingDate = bookingDate;
        this.bookingConfirmed = bookingConfirmed;
    }

    public String getId() {
        return id;
    }

    public LocalDate getBookingDate(LocalDate bookingDate) {
        return this.bookingDate;
    }

    public boolean isBookingConfirmed() {
        return bookingConfirmed;
    }

    @Override
    public String toString() {
        return "Bookings[id=" + id + ", bookingDate=" + bookingDate +", bookingConfirmed=" + bookingConfirmed+"]";
    }

}
