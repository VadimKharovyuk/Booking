package com.example.booking.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class MainPageController {
    @GetMapping("/")
    public ModelAndView home(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("index");
        // Добавление объекта request в модель для использования в Thymeleaf
        modelAndView.addObject("requestURI", request.getRequestURI());
        return modelAndView;
    }
}
