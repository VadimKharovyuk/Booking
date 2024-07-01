package com.example.booking.service;

import com.example.booking.model.Resource;
import com.example.booking.model.User;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private  final JavaMailSender mailSender;

    public void sendBookingConfirmation(User user, Resource resource) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Booking Confirmation");
        message.setText("Your booking for " + resource.getName() + " has been confirmed.");
        mailSender.send(message);
    }

    public void sendBookingCancellation(User user, Resource resource) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Booking Cancellation");
        message.setText("Your booking for " + resource.getName() + " has been cancelled.");
        mailSender.send(message);
    }
}
