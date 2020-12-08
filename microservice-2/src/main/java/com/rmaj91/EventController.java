package com.rmaj91;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final RabbitEventRepository rabbitEventRepository;

    @GetMapping("/receiver/events")
    public List<RabbitEventEntity> getEvents() {
        return rabbitEventRepository.findAll();
    }
}
