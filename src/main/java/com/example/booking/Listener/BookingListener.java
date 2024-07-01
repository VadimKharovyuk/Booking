package com.example.booking.Listener;

import com.example.booking.pojo.BookingRequest;
import com.example.booking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingListener {

    private final BookingService bookingService;

@RabbitListener( queues = "bookingQueue")
    public void handleBookingRequest(BookingRequest request) {
        bookingService.createBooking(request);

    }



//
//        @RabbitListener(
//            bindings = @QueueBinding(
//                    value = @Queue(value = "bookingQueue", durable = "true"),
//                    exchange = @Exchange(value = "bookingExchange", durable = "true", type = ExchangeTypes.FANOUT)
//            )
//    )


}
