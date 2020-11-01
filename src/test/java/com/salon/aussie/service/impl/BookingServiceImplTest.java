package com.salon.aussie.service.impl;

import com.salon.aussie.domain.Booking;
import com.salon.aussie.data.BookingRepository;
import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
class BookingServiceImplTest {

    @Mock
    BookingRepository bookingRepository;

    @Mock
    MongoTemplate mongoTemplate;

    @InjectMocks
    BookingServiceImpl bookingService;

    @BeforeEach
    void  setUp(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void createBookingServiceSuccessTest(){
        Booking booking = new Booking();
        booking.setId(123546);
        booking.setBarberId(12);
        booking.setBarberName("tester");
        booking.setCustomerName("test");
        booking.setBookingDate("4");
        booking.setCustomerPhoneNumber("1234654");
        booking.setTimeSlotFrom("5");
        booking.setTimeSlotTo("6");
        Mockito.when(bookingRepository.save(booking)).thenReturn(booking);
        Assert.assertEquals(booking,bookingService.createBookingService(booking));
    }

    @Test
    void getAllBookingServicesSuccessTest(){
        List<Booking> bookingList = new ArrayList<>();
        Booking booking = new Booking();
        booking.setId(123546);
        booking.setBarberId(12);
        booking.setBarberName("tester");
        booking.setCustomerName("test");
        booking.setBookingDate("4");
        booking.setCustomerPhoneNumber("1234654");
        booking.setTimeSlotFrom("5");
        booking.setTimeSlotTo("6");
        bookingList.add(booking);
        Mockito.when(bookingRepository.findAll()).thenReturn(bookingList);
        Assert.assertEquals(bookingList,bookingService.getAllBookingServices());
    }

    @Test
    void getBarberAvailabilitySuccessTest(){
        List<Booking> bookingList = new ArrayList<>();
        Booking booking = new Booking();
        booking.setId(123546);
        booking.setBarberId(12);
        booking.setBarberName("tester");
        booking.setCustomerName("test");
        booking.setBookingDate("4");
        booking.setCustomerPhoneNumber("1234654");
        booking.setTimeSlotFrom("5");
        booking.setTimeSlotTo("6");
        bookingList.add(booking);
        Mockito.when(mongoTemplate.find(Mockito.any(),Mockito.any())).thenReturn(Collections.singletonList(bookingList));
        Assert.assertEquals(false,bookingService.getBarberAvailability(booking));
    }

    @Test
    void getBarberAvailabilityListEmptyTest(){
        List<Booking> bookingList = new ArrayList<>();
        Booking booking = new Booking();
        booking.setId(123546);
        booking.setBarberId(12);
        booking.setBarberName("tester");
        booking.setCustomerName("test");
        booking.setBookingDate("4");
        booking.setCustomerPhoneNumber("1234654");
        booking.setTimeSlotFrom("5");
        booking.setTimeSlotTo("6");
        Mockito.when(mongoTemplate.find(Mockito.any(),Mockito.any())).thenReturn(Collections.emptyList());
        Assert.assertEquals(true,bookingService.getBarberAvailability(booking));
    }
}