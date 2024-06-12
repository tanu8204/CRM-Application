package com.example.CRMProject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/login")
    public String login() {
        // Implement Google OAuth or OAuth2 for login authentication
        // Redirect user to Google login page
        return "Redirecting to Google login page...";
    }

    @GetMapping("/callback")
    public String callback() {
        // Handle callback after successful authentication
        // Generate and return JWT token or set session attributes
        return "Authenticated successfully!";
    }

    @GetMapping("/logout")
    public String logout() {
        // Implement logout functionality
        // Clear session attributes or invalidate JWT token
        return "Logged out successfully!";
    }
}
