package com.rmaj91;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class EventController {

    private final RabbitEventRepository rabbitEventRepository;

    @GetMapping("/receiver/events")
    public List<RabbitEvent> getEvents() {
        return rabbitEventRepository.findAll().stream().map(rabbitEventEntity -> {
            return new RabbitEvent(
                    rabbitEventEntity.getDescription(),
                    rabbitEventEntity.getMessage(),
                    rabbitEventEntity.getId());
        })
                .collect(Collectors.toList());
    }
}
