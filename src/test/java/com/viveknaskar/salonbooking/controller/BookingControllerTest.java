package com.viveknaskar.salonbooking.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.viveknaskar.salonbooking.domain.Booking;
import com.viveknaskar.salonbooking.service.BookingService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = BookingController.class)
public class BookingControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    BookingService bookingService;

    @Test
    public void getBarberAllRecordsTest() throws Exception {
        List<Booking> bookingList = new ArrayList<>();
        Booking booking = new Booking();
        booking.setId(123546);
        booking.setBarberId(12);
        booking.setBarberName("tester");
        booking.setName("test");
        booking.setBookingDate("4");
        booking.setPhone("1234654");
        booking.setStartTime("5");
        booking.setEndTime("6");
        booking.setSubject("testing");
        booking.setLocation("Melbourne");
        booking.setComments("Good");
        booking.setBlock(true);
        bookingList.add(booking);

        Mockito.when(bookingService.getAllBookingServices()).thenReturn(bookingList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/booking/details").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void getBarberAllRecordsAdminTest() throws Exception {
        List<Booking> bookingList = new ArrayList<>();
        Booking booking = new Booking();
        booking.setId(123546);
        booking.setBarberId(12);
        booking.setBarberName("tester");
        booking.setName("test");
        booking.setBookingDate("4");
        booking.setPhone("1234654");
        booking.setStartTime("5");
        booking.setEndTime("6");
        booking.setSubject("testing");
        booking.setLocation("Melbourne");
        booking.setComments("Good");
        booking.setBlock(false);
        bookingList.add(booking);

        Mockito.when(bookingService.getAllBookingServicesForAdmin()).thenReturn(bookingList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/booking/admin/details").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void getBarberAllRecordsAdminExceptionTest() throws Exception {
        Mockito.when(bookingService.getAllBookingServicesForAdmin()).thenThrow(new RuntimeException());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/booking/admin/details").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), result.getResponse().getStatus());
    }

    @Test
    public void getBarberAllRecordsFailTest() throws Exception {
        Mockito.when(bookingService.getAllBookingServices()).thenThrow(new RuntimeException());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/booking/details").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), result.getResponse().getStatus());
    }

    @Test
    public void createBookingServiceSuccessTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Booking booking = new Booking();
        booking.setId(123546);
        booking.setBarberId(12);
        booking.setBarberName("tester");
        booking.setName("test");
        booking.setBookingDate("4");
        booking.setPhone("1234654");
        booking.setStartTime("5");
        booking.setEndTime("6");
        booking.setSubject("testing");
        booking.setLocation("Melbourne");
        booking.setComments("Good");
        booking.setBlock(true);
        String json = mapper.writeValueAsString(booking);
        Mockito.when(bookingService.createBookingService(booking)).thenReturn(booking);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/booking/create")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.CREATED.value(), result.getResponse().getStatus());
    }

    @Test
    public void createBookingServiceFailTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Booking booking = new Booking();
        booking.setId(123546);
        booking.setBarberId(12);
        booking.setBarberName("tester");
        booking.setBookingDate("4");
        String json = mapper.writeValueAsString(booking);
        Mockito.when(bookingService.createBookingService(booking)).thenThrow(new RuntimeException());
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/booking/create")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), result.getResponse().getStatus());
    }

    @Test
    public void checkBarberAvailabilitySuccessTest() throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Booking booking = new Booking();
        booking.setId(123546);
        booking.setBarberId(12);
        booking.setBarberName("tester");
        booking.setName("test");
        booking.setBookingDate("4");
        booking.setPhone("1234654");
        booking.setStartTime("5");
        booking.setEndTime("6");
        booking.setSubject("testing");
        booking.setLocation("Melbourne");
        booking.setComments("Good");
        booking.setBlock(true);
        String json = mapper.writeValueAsString(booking);
        Mockito.when(bookingService.getBarberAvailability(booking)).thenReturn(true);
        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/booking/barber/availability")
                .accept(MediaType.APPLICATION_JSON).content(json)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void getBookingIdForBarberTest() throws Exception {
        List<Booking> bookingList = new ArrayList<>();
        Booking booking = new Booking();
        booking.setId(123546);
        booking.setBarberId(12);
        booking.setBarberName("tester");
        booking.setName("test");
        booking.setBookingDate("4");
        booking.setPhone("1234654");
        booking.setStartTime("5");
        booking.setEndTime("6");
        booking.setSubject("testing");
        booking.setLocation("Melbourne");
        booking.setComments("Good");
        booking.setBlock(false);
        bookingList.add(booking);

        Mockito.when(bookingService.getBookingOfBarber(12)).thenReturn(bookingList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/booking/details/12").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.OK.value(), result.getResponse().getStatus());
    }

    @Test
    public void getBookingIdForBarberFailTest() throws Exception {
        Mockito.when(bookingService.getBookingOfBarber(12)).thenThrow(new RuntimeException());
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
                "/booking/details/12").accept(
                MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        Assert.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR.value(), result.getResponse().getStatus());
    }
}