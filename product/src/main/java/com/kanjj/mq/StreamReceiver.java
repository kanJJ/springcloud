package com.kanjj.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * Created by Chris on 2018/10/16.
 */
@Component
@Slf4j
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    @StreamListener(StreamClient.INPUT)
    @SendTo(StreamClient.OUTPUT)
    public Object process(Object message) {
        log.info("Stream input receive: {}",  message);
        return "ok";
    }

    @StreamListener(StreamClient.OUTPUT)
    public void process2(String message) {
        log.info("Stream output receive: {}", message);
    }

}
