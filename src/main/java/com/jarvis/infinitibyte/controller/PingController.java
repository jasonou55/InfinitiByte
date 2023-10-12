package com.jarvis.infinitibyte.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/public")
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "Pong";
    }
}
