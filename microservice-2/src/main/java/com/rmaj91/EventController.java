package com.rmaj91;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final EventHandler eventHandler;

    @GetMapping("/receiver/events")
    public List<RabbitEvent> getEvents() {
        return eventHandler.getEvents();
    }
}
