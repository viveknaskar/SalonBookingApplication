package com.viveknaskar.salonbooking.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "booking_details")
public class Booking {
    @Id
    private long id;
    private String bookingDate;
    private String name;
    private String phone;
    private long barberId;
    private String barberName;
    private String startTime;
    private String endTime;
    private String subject;
    private String location;
    private String comments;
    @JsonProperty("IsBlock")
    private boolean isBlock;
}
