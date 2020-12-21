package com.sya.amqp.tutorials.rabbitmqamqptutorials.config;

import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.Random;

public class FanoutSender
{
    @Autowired
    public RabbitTemplate template;

    @Autowired
    public FanoutExchange fanout;

    @Scheduled(fixedDelay = 1000, initialDelay = 500)
    public void send() {
        String message = "Hello World!"+ new Random().ints().findFirst().getAsInt();
        template.convertAndSend(fanout.getName(),"",message);
        System.out.println(" [x] Sent '" + message + "'");
    }
}
