package com.example.booking.service;

import com.example.booking.model.Booking;
import com.example.booking.model.Resource;
import com.example.booking.model.User;
import com.example.booking.pojo.BookingRequest;
import com.example.booking.pojo.UserRegistrationDto;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EmailService {
    private  final JavaMailSender mailSender;
    private final RabbitTemplate rabbitTemplate;



public void sendBookingConfirmation(User user, Resource resource) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setTo(user.getEmail());
    message.setSubject("Booking Confirmation");
    message.setText("Your booking for " + resource.getName() + " has been confirmed.");
    mailSender.send(message);


    // Отправляем объект Booking в RabbitMQ
    Booking booking = new Booking();
    booking.setUser(user);
    booking.setResource(resource);
    rabbitTemplate.convertAndSend("bookingExchange", "", booking);

}



    public void sendBookingCancellation(User user, Resource resource) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(user.getEmail());
        message.setSubject("Booking Cancellation");
        message.setText("Your booking for " + resource.getName() + " has been cancelled.");
        mailSender.send(message);


    }
}
