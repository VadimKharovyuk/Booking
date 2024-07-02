package com.example.booking.controller;

import com.example.booking.pojo.UserRegistrationDto;
import com.example.booking.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@AllArgsConstructor
public class RegistrationController {
    private  final  UserService userService;

    @GetMapping("/register")
    public String showRegistrationForm(@ModelAttribute("registrationDto") UserRegistrationDto registrationDto) {
        return "registration-form";
    }
    @PostMapping("/register/user")
    public String processRegistrationForm(@ModelAttribute("registrationDto") UserRegistrationDto registrationDto, RedirectAttributes redirectAttributes) {
        // Проверяем уникальность email перед сохранением
        if (userService.emailExists(registrationDto.getEmail())) {
            redirectAttributes.addFlashAttribute("error", "Email already exists!");
            return "redirect:/register";
        }

        // Ваша логика сохранения пользователя
         userService.registerUser(registrationDto);
        return "redirect:/registration-successful";
    }




    @GetMapping("/registration-successful")
    public String registration(){
        return "registration-successful";
    }
}
