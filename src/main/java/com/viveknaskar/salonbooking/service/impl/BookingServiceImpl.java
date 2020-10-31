package com.viveknaskar.salonbooking.service.impl;

import com.viveknaskar.salonbooking.data.BookingRepository;
import com.viveknaskar.salonbooking.domain.Booking;
import com.viveknaskar.salonbooking.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Component
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    MongoTemplate mongoTemplate;

    @Override
    public Booking createBookingService(Booking bookingDetails) {
        bookingDetails.setId(generateBookingId());
        return bookingRepository.save(bookingDetails);
    }

    @Override
    public List<Booking> getAllBookingServices() {
        List<Booking> bookingDetailsList = bookingRepository.findAll();
        Comparator<Booking> comparator = Comparator.comparing(Booking::getBookingDate);
        Collections.sort(bookingDetailsList, comparator);
        return bookingDetailsList;
    }

    @Override
    public boolean getBarberAvailability(Booking bookingDetails) {

        String bookingDate = bookingDetails.getBookingDate();
        String timeSlotFrom = bookingDetails.getTimeSlotFrom();
        String timeSlotTo = bookingDetails.getTimeSlotTo();

        Query query = new Query();
        query.addCriteria(
                new Criteria().andOperator(
                        Criteria.where("bookingDate").is(bookingDate),
                        Criteria.where("timeSlotFrom").is(timeSlotFrom),
                        Criteria.where("timeSlotTo").is(timeSlotTo),
                        Criteria.where("barberId").is(bookingDetails.getBarberId())
                )
        );

        List<Booking> bookingDetailsList = mongoTemplate.find(query, Booking.class);
        if(bookingDetailsList.isEmpty()){
            return true;
        }
        return false;
    }

    private long generateBookingId() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        String randomBookingId = String.format("%05d", num);
        return Long.valueOf(randomBookingId);
    }


}