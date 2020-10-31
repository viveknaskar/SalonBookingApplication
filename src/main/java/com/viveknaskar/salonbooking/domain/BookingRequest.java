package com.viveknaskar.salonbooking.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = false)
public class BookingRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String phoneNumber;

    private String bookingDate;
}
