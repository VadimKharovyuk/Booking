package com.example.booking.controller;

import com.example.booking.pojo.BookingRequest;
import com.example.booking.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;

@GetMapping()
public String boofingForm(){
    return "booking";
}

@GetMapping("booking-successful")
public String bookingssuccessful(){
    return "booking-successful";
}

    @PostMapping("")
    public String createBooking(@ModelAttribute("bookingRequest")  @Validated BookingRequest bookingRequest, BindingResult result) {
        if (result.hasErrors()) {

            return "booking";
        }

        bookingService.createBooking(bookingRequest);

        return "redirect:/bookings/booking-successful";
    }
}
