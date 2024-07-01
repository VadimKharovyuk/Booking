package com.example.booking.controller;

import com.example.booking.service.ResourceService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
@Controller
@AllArgsConstructor
public class MainPageController {

    private final ResourceService resourceService;
    @GetMapping("/")
    public ModelAndView home(HttpServletRequest request , Model model) {
        ModelAndView modelAndView = new ModelAndView("index");
        model.addAttribute("resources",resourceService.findAll());

        modelAndView.addObject("requestURI", request.getRequestURI());
        return modelAndView;
    }
}
