package com.example.booking.controller;

import com.example.booking.model.Resource;
import com.example.booking.service.ResourceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/resources")
@AllArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @GetMapping("")
    public String getAllResources(Model model) {
        model.addAttribute("resources", resourceService.findAll());
        return "resources";
    }

    @GetMapping("/{id}")
    public String getResourceById(@PathVariable Long id, Model model) {
        Resource resource = resourceService.getResourceById(id);
        model.addAttribute("resource", resource);
        return "resource_details";
    }

    @PostMapping("")
    public String addResource(@ModelAttribute Resource resource) {
        resourceService.addResource(resource);
        return "redirect:/resources";
    }

    // Другие методы контроллера, если необходимо
}
