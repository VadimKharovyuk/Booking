package com.example.booking.Listener;

import com.example.booking.model.Booking;
import com.example.booking.model.Resource;
import com.example.booking.model.User;
import com.example.booking.pojo.BookingRequest;
import com.example.booking.service.BookingService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingListener {

    @Autowired
    private BookingService bookingService;

    @RabbitListener(queues = "bookingQueue")
    public void handleBookingRequest(BookingRequest bookingRequest) {
        // Создание объекта Booking на основе данных из BookingRequest
        User user = bookingRequest.getUser();
        Resource resource = bookingRequest.getResource();

        Booking booking = new Booking();
        booking.setUser(user);
        booking.setResource(resource);


        System.out.println(" Вызов сервиса для создания бронирования c bookingQueue" );
        bookingService.createBooking(booking);
    }
}