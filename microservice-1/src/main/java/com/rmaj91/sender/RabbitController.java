package com.rmaj91.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RabbitController {

    private final RabbitService rabbitService;

    @PostMapping("/sender/send")
    public void sendEvent(@RequestParam String message, @RequestParam String description) {
        rabbitService.sendEvent(message, description);
    }
}
