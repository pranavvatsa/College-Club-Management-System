package com.example.application.ooad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm() {
        return "redirect:/login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password) {
        if (userService.authenticate(username, password)) {
            return "redirect:/dashboard"; // Redirect to dashboard upon successful login
        } else {
            return "redirect:/register"; // Redirect back to login page with error parameter
        }
    }
}

