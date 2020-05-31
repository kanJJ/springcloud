package com.kanjj.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Created by Chris on 2018/10/15.
 */
@Slf4j
@Component
public class MqReceiver {

   /* @RabbitListener(queuesToDeclare = @Queue("myQueue"))
    public void process(Object message) {
        log.info("mqReceiver : {}", message);
    }*/

    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myExchange"),
            key = "boy",
            value = @Queue("boyQueue")
    ))
    public void processGroup1(Object message) {
        log.info("boyQueue : {}", message);
    }


    @RabbitListener(bindings = @QueueBinding(
            exchange = @Exchange("myExchange"),
            key = "girl",
            value = @Queue("girlQueue")
    ))
    public void processGroup2(Object message) {
        log.info("girlQueue : {}", message);
    }

}
