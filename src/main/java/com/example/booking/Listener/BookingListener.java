package com.example.booking.Listener;

import com.example.booking.pojo.BookingRequest;
import com.example.booking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingListener {

    private final BookingService bookingService;

//    @RabbitListener(queues = "bookingQueue")
@RabbitListener(
        bindings = @QueueBinding(
                value = @Queue(value = "bookingQueue", durable = "true"),
                exchange = @Exchange(value = "bookingExchange", durable = "true", type = ExchangeTypes.DIRECT),
                key = "booking"
        )
)

    public void handleBookingRequest(BookingRequest request) {
        bookingService.createBooking(request);
    }
}
