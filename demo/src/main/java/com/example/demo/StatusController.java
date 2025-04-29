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
        return statusService.processStatus(PathType.HELLO);
    }

    @GetMapping("/departure")
    public String sayGoodbye() {
        return statusService.processStatus(PathType.GOODBYE);

    }

    @GetMapping("/success")
    public String getStatus() {
        return statusService.processStatus(PathType.SUCCESS);
    }
}
