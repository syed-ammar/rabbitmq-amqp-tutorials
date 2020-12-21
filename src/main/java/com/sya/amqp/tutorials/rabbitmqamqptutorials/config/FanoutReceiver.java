package com.sya.amqp.tutorials.rabbitmqamqptutorials.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;

public class FanoutReceiver
{
    @RabbitListener(queues = "#{autoDeleteQueue1.name}")
    public void preReceive1(String message){
        receive(message,1);
    }

    @RabbitListener(queues = "#{autoDeleteQueue2.name}")
    public void preReceive2(String message){
        receive(message,2);
    }

    public void receive(String message, int qNo)
    {
        System.out.println(" [x] Received '" + message + "'" + "From" +qNo);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
