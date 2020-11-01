package com.salon.aussie.domain;

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

    public Booking adminView() {
        Booking booking = new Booking();
        booking.setId(this.getId());
        booking.setBarberId(this.getBarberId());
        booking.setBarberName(this.getBarberName());
        booking.setBookingDate(this.getBookingDate());
        booking.setBlock(false);
        booking.setName(this.getName());
        booking.setComments(this.getComments());
        booking.setEndTime(this.getEndTime());
        booking.setLocation(this.getLocation());
        booking.setPhone(this.getPhone());
        booking.setStartTime(this.getStartTime());
        booking.setSubject(this.getSubject());
        return booking;
    }
}
