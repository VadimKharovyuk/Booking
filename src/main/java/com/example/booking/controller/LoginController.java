package com.example.booking.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm() {
        return "login-form";
    }

    // Дополнительная логика для обработки входа пользователя может быть добавлена здесь
}
