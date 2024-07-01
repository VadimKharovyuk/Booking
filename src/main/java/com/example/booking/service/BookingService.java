package com.example.booking.service;

import com.example.booking.model.Booking;
import com.example.booking.model.Resource;
import com.example.booking.model.User;
import com.example.booking.pojo.BookingRequest;
import com.example.booking.repository.BookingRepository;
import com.example.booking.repository.ResourceRepository;
import com.example.booking.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {
    private  final BookingRepository bookingRepository;
    private  final ResourceRepository resourceRepository;
    private  final EmailService emailService;
    private final UserRepository userRepository;

    public void createBooking(BookingRequest request) {
        Resource resource = resourceRepository.findById(request.getResourceId())
                .orElseThrow(() -> new IllegalArgumentException("Resource not found with id: " + request.getResourceId()));

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found with id: " + request.getUserId()));

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setResource(resource);
        booking.setStartTime(request.getStartTime());
        booking.setEndTime(request.getEndTime());

        bookingRepository.save(booking);
        emailService.sendBookingConfirmation(user, resource);
    }
}
