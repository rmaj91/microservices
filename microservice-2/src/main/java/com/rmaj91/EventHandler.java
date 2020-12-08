package com.rmaj91;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.AmqpRejectAndDontRequeueException;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EventHandler {

    private final RabbitEventRepository rabbitEventRepository;


    @RabbitListener(queues = "${test.queue}")
    public void sout(RabbitEvent rabbitEvent) {
        try {
            Thread.sleep(2000);
            if (rabbitEvent.getSomeId() == 999) {
                throw new Exception();
            }
            RabbitEventEntity rabbitEventEntity = new RabbitEventEntity();
            rabbitEventEntity.setDescription(rabbitEvent.getDescription());
            rabbitEventEntity.setMessage(rabbitEvent.getAdditionalData());
            rabbitEventRepository.save(rabbitEventEntity);
            System.out.println(rabbitEvent);
        } catch (Exception e) {
            throw new AmqpRejectAndDontRequeueException("");
        }
    }
}
