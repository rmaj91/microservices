package com.rmaj91;

import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class EventHandler {

    @RabbitListener(queues = "${test.queue}")
    public void sout(RabbitEvent rabbitEvent) {
        try {
            Thread.sleep(2000);
            if (rabbitEvent.getSomeId() == 999) {
                throw new Exception();
            }
            System.out.println(rabbitEvent);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException("");
        }
    }
}
