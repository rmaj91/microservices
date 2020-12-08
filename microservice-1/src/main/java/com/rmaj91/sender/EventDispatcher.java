package com.rmaj91.sender;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventDispatcher {

    private final RabbitTemplate rabbitTemplate;

    @Value("${test.exchange}")
    private String multiplicationExchange;
    @Value("${test.exchange.key}")
    private String multiplicationSolvedRoutingKey;

    public void send(final RabbitEventEntity rabbitEvent) {
        rabbitTemplate.convertAndSend(
                multiplicationExchange,
                multiplicationSolvedRoutingKey,
                rabbitEvent);
    }
}
