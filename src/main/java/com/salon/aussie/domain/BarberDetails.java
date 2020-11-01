package com.salon.aussie.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "barber_details")
public class BarberDetails {
    @Id
    private long id;
    private String name;
    private String address;
    private String phoneNumber;
    private String experience;
    private String rating;
    private String chargePerSession;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getChargePerSession() {
        return chargePerSession;
    }

    public void setChargePerSession(String chargePerSession) {
        this.chargePerSession = chargePerSession;
    }
}
