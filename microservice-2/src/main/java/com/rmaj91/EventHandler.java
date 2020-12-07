package com.rmaj91;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class EventHandler {

    private final List<RabbitEvent> events = new LinkedList<>();

    @RabbitListener(queues = "${test.queue}")
    public void sout(RabbitEvent rabbitEvent) {
        try {
            Thread.sleep(2000);
            if (rabbitEvent.getSomeId() == 999) {
                throw new Exception();
            }
            events.add(rabbitEvent);
            System.out.println(rabbitEvent);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException("");
        }
    }

    public List<RabbitEvent> getEvents() {
        return events;
    }
}
