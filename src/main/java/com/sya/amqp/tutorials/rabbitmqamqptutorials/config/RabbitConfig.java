package com.sya.amqp.tutorials.rabbitmqamqptutorials.config;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.listener.RabbitListenerContainerFactory;
import org.springframework.amqp.rabbit.listener.SimpleMessageListenerContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("inception")
@Configuration
public class RabbitConfig
{
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    @Bean
    public RabbitListenerContainerFactory<SimpleMessageListenerContainer> prefetchRabbitListenerContainerFactory(ConnectionFactory rabbitConnectionFactory) {
        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
        factory.setConnectionFactory(rabbitConnectionFactory);
        factory.setPrefetchCount(3);
        return factory;
    }

    @Profile("receiver")
    @Bean
    public MessageReceiver receiver() {
        return new MessageReceiver();
    }


    @Profile("sender")
    @Bean
    public MessageSender sender() {
        return new MessageSender();
    }
}
