//package com.example.booking.controller;
//
//import com.example.booking.pojo.BookingRequest;
//import com.example.booking.service.BookingService;
//import lombok.AllArgsConstructor;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//@RequestMapping("/bookings")
//@AllArgsConstructor
//public class BookingController {
//
//
//    private final BookingService bookingService;
//
//@GetMapping()
//public String boofingForm(){
//    return "booking";
//}
//
//@GetMapping("booking-successful")
//public String bookingssuccessful(){
//    return "booking-successful";
//}
//
//    @PostMapping("")
//    public String createBooking(@ModelAttribute("bookingRequest")  @Validated BookingRequest bookingRequest, BindingResult result) {
//        if (result.hasErrors()) {
//
//            return "booking";
//        }
//
//        bookingService.createBooking(bookingRequest);
//
//        return "redirect:/bookings/booking-successful";
//    }
//}


package com.example.booking.controller;

import com.example.booking.pojo.BookingRequest;
import com.example.booking.model.Resource;
import com.example.booking.model.User;
import com.example.booking.service.BookingService;
import com.example.booking.service.ResourceService;
import com.example.booking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller
@RequestMapping("/bookings")
@AllArgsConstructor
public class BookingController {

    private final BookingService bookingService;
    private final ResourceService resourceService;
    private final UserService userService;

    @GetMapping("")
    public String bookingForm(Model model) {
        List<Resource> resources = resourceService.findAll();
        List<User> users = userService.findAll();

        model.addAttribute("resources", resources);
        model.addAttribute("users", users);
        model.addAttribute("bookingRequest", new BookingRequest());

        return "booking";
    }

    @GetMapping("/booking-successful")
    public String bookingsSuccessful() {
        return "booking-successful";
    }

    @PostMapping("")
    public String createBooking(@ModelAttribute("bookingRequest") @Validated BookingRequest bookingRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("resources", resourceService.findAll());
            model.addAttribute("users", userService.findAll());
            return "booking";
        }

        bookingService.createBooking(bookingRequest);

        return "redirect:/bookings/booking-successful";
    }
}
