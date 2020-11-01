package com.salon.aussie.controller;

import com.salon.aussie.domain.Booking;
import com.salon.aussie.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    BookingService bookingService;

    @PostMapping("/create")
    public ResponseEntity createBookingService(@RequestBody Booking bookingDetails) {
        try {
            return new ResponseEntity<>(bookingService.createBookingService(bookingDetails), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/details")
    public ResponseEntity getBarberAllRecords() {
        try {
            return new ResponseEntity<>(bookingService.getAllBookingServices(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/barber/availability")
    public ResponseEntity checkBarberAvailability(@RequestBody Booking bookingDetails) {
        try {
            return new ResponseEntity<>(bookingService.getBarberAvailability(bookingDetails), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}