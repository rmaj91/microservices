package com.rmaj91.sender;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
public class RabbitController {

    private final RabbitService rabbitService;
    @Value("${server.port}")
    private String port;

    @PostMapping("/sender/send")
    public void sendEvent(@RequestParam String message, @RequestParam String description) {
        log.info("Here service from port: " + port);
        rabbitService.sendEvent(message, description);
    }
}
