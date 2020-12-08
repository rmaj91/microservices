package com.rmaj91.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RabbitService {

    private final EventDispatcher eventDispatcher;
    private final RabbitEventRepository rabbitEventRepository;

    public void sendEvent(String message, String description) {
        RabbitEventEntity rabbitEventEntity = new RabbitEventEntity();
        rabbitEventEntity.setDescription(description);
        rabbitEventEntity.setMessage(message);
        rabbitEventRepository.save(rabbitEventEntity);
        eventDispatcher.send(rabbitEventEntity);
    }
}
