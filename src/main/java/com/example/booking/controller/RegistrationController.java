package com.example.booking.controller;

import com.example.booking.pojo.UserRegistrationDto;
import com.example.booking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
@Controller
@AllArgsConstructor
public class RegistrationController {
    private  final  UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(@ModelAttribute("registrationDto") UserRegistrationDto registrationDto) {
        return "registration-form";
    }

    @PostMapping("/register/user")
    public String registerUser(@ModelAttribute UserRegistrationDto registrationDto) {
        userService.registerUser(registrationDto);
        return "redirect:/registration-successful";
    }
    @GetMapping("/registration-successful")
    public String registration(){
        return "registration-successful";
    }
}
