package com.viveknaskar.salonbooking.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
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
}
