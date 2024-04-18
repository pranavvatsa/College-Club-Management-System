package com.example.application.ooad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @Autowired
    private ClubRepository clubRepository;

    @GetMapping("/dashboard")
    public String showDashboard(Model model) {
        // Ensure clubRepository is not null before using it
        if (clubRepository != null) {
            // Your logic here
            // For example, fetch data from clubRepository and add it to the model
            model.addAttribute("clubs", clubRepository.findAll());
        } else {
            // Log an error or handle the situation appropriately
            System.err.println("ClubRepository is null");
            // You can also throw an exception or handle the situation according to your application's requirements
        }
        return "dashboard";
    }
}



