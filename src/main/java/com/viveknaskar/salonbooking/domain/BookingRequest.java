package com.viveknaskar.salonbooking.domain;

import lombok.Data;

@Data
public class BookingRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String bookingDate;
}
