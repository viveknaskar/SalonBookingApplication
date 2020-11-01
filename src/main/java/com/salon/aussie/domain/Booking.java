package com.salon.aussie.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "booking_details")
public class Booking {
    @Id
    private long id;
    private String bookingDate;
    private String customerName;
    private String customerPhoneNumber;
    private long barberId;
    private String barberName;
    private String timeSlotFrom;
    private String timeSlotTo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public long getBarberId() {
        return barberId;
    }

    public void setBarberId(long barberId) {
        this.barberId = barberId;
    }

    public String getBarberName() {
        return barberName;
    }

    public void setBarberName(String barberName) {
        this.barberName = barberName;
    }

    public String getTimeSlotFrom() {
        return timeSlotFrom;
    }

    public void setTimeSlotFrom(String timeSlotFrom) {
        this.timeSlotFrom = timeSlotFrom;
    }

    public String getTimeSlotTo() {
        return timeSlotTo;
    }

    public void setTimeSlotTo(String timeSlotTo) {
        this.timeSlotTo = timeSlotTo;
    }
}
