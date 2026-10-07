package com.hotelbooking.onlinehotelbooking.service;

import com.hotelbooking.onlinehotelbooking.model.Booking;
import com.hotelbooking.onlinehotelbooking.repository.BookingRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    // Create a new booking
    public Booking createBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    // Get all bookings
    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    // Get bookings by email
    public List<Booking> getBookingsByEmail(String email) {
        return bookingRepository.findByEmail(email);
    }

    // Cancel/Delete booking
    public void cancelBooking(Long id) {
        bookingRepository.deleteById(id);
    }
}