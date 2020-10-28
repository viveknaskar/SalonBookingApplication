package com.viveknaskar.salonbooking.domain;

import lombok.Data;

import java.time.LocalDate;

@Data
public class BookingSummary {

    private String bookingId;

    /**
     * Inclusive date.
     */
    private LocalDate bookingDate;

}
