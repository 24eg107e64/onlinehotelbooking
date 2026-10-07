package com.hotelbooking.onlinehotelbooking.controller;

import com.hotelbooking.onlinehotelbooking.model.Booking;
import com.hotelbooking.onlinehotelbooking.service.BookingService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    // Create booking
    @PostMapping
    public Booking createBooking(@RequestBody Booking booking) {

        return bookingService.createBooking(booking);
    }

    // Get all bookings
    @GetMapping
    public List<Booking> getAllBookings() {

        return bookingService.getAllBookings();
    }

    // Get bookings by email
    @GetMapping("/email/{email}")
    public List<Booking> getBookingsByEmail(
            @PathVariable String email) {

        return bookingService.getBookingsByEmail(email);
    }

    // Cancel booking
    @DeleteMapping("/{id}")
    public String cancelBooking(@PathVariable Long id) {

        bookingService.cancelBooking(id);

        return "Booking cancelled successfully";
    }
}