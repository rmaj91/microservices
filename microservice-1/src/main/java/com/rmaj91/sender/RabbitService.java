package com.rmaj91.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitService {

    private final EventDispatcher eventDispatcher;

    public void sendEvent() {
        RabbitEvent rabbitEvent = new RabbitEvent(
                "description",
                "additional data",
                17);
        eventDispatcher.send(rabbitEvent);
    }
}
