package com.rmaj91.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitService {

    private final EventDispatcher eventDispatcher;
    private int count;

    public void sendEvent(String message, String description) {
        RabbitEvent rabbitEvent = new RabbitEvent(
                description,
                message,
                ++count);
        eventDispatcher.send(rabbitEvent);
    }
}
