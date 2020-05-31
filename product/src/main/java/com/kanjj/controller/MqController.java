package com.kanjj.controller;

import com.kanjj.mq.StreamClient;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * Created by Chris on 2018/10/15.
 */
@RestController
public class MqController {

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Autowired
    private StreamClient streamClient;

    @GetMapping("/sendboy")
    public void sendMq() {
       //  amqpTemplate.convertAndSend("myQueue", "now:" + new Date());
        amqpTemplate.convertAndSend("myExchange", "boy" , "now:" + new Date());
    }

    @GetMapping("/sendgirl")
    public void sendMq2() {
        //  amqpTemplate.convertAndSend("myQueue", "now:" + new Date());
        amqpTemplate.convertAndSend("myExchange", "girl" , "now:" + new Date());
    }

    @GetMapping("/send")
    public void sendStream() {
        String message = "now :" + new Date();
        streamClient.input().send(MessageBuilder.withPayload(message).build());
    }

}
