package com.salon.aussie.service.impl;

import com.salon.aussie.domain.Booking;
import com.salon.aussie.data.BookingRepository;
import com.salon.aussie.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.ArrayList;
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
        bookingDetails.setBlock(true);
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
    public List<Booking> getAllBookingServicesForAdmin() {
        List<Booking> adminViewList = new ArrayList<>();
        List<Booking> bookingList = getAllBookingServices();
        for (Booking booking:bookingList) {
            adminViewList.add(booking.adminView());
        }
        return adminViewList;
    }

    @Override
    public boolean getBarberAvailability(Booking bookingDetails) {

        String bookingDate = bookingDetails.getBookingDate();
        String startTime = bookingDetails.getStartTime();
        String endTime = bookingDetails.getEndTime();

        Query query = new Query();
        query.addCriteria(
                new Criteria().andOperator(
                        Criteria.where("bookingDate").is(bookingDate),
                        Criteria.where("startTime").is(startTime),
                        Criteria.where("endTime").is(endTime),
                        Criteria.where("barberId").is(bookingDetails.getBarberId())
                )
        );

        List<Booking> bookingDetailsList = mongoTemplate.find(query, Booking.class);
        if(bookingDetailsList.isEmpty()){
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getBookingOfBarber(long id) {
        List<Booking> barberBookingList = bookingRepository.findByBarberId(id);
        return barberBookingList;
    }

    private long generateBookingId() {
        SecureRandom random = new SecureRandom();
        int num = random.nextInt(100000);
        String randomBookingId = String.format("%05d", num);
        return Long.valueOf(randomBookingId);
    }


}