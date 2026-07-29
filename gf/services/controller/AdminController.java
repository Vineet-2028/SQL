package com.backend.backend.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
@CrossOrigin(origins = "http://localhost:5173")
public class AdminController {

    @GetMapping("/test")
    public String adminTest() {
        return "Admin access working";
    }
}