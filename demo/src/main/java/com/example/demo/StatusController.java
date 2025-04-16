package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StatusController {

    private final StatusService statusService;

    public StatusController(StatusService statusService) {
        this.statusService = statusService;
    }

    @GetMapping("/arrival")
    public String sayHello() {
        return "spring fundamentals/hello";
    }

    @GetMapping("/departure")
    public String sayGoodbye() {
        return "spring fundamentals/goodbye";
    }

    @GetMapping("/success")
    public String getStatus() {
        return "spring fundamentals/success";
    }
}
