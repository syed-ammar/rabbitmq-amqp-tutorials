package com.sya.amqp.tutorials.rabbitmqamqptutorials.config;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@RabbitListener(queues = "hello", containerFactory = "prefetchRabbitListenerContainerFactory")
public class MessageReceiver
{
    @RabbitHandler
    public void receive(String in) {
        System.out.println(" [x] Received '" + in + "'");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
