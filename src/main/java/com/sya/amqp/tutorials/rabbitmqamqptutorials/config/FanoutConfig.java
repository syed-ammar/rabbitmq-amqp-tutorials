package com.sya.amqp.tutorials.rabbitmqamqptutorials.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Profile("fanout")
@Configuration
public class FanoutConfig
{
    @Bean
    public FanoutExchange fanout(){
        return new FanoutExchange("fanout");
    }

    @Profile("sender")
    @Bean
    public FanoutSender sender()
    {
        return new FanoutSender();
    }

    @Profile("receiver")
    public static class Receiver
    {
        @Bean
        public Queue autoDeleteQueue1()
        {
            return new AnonymousQueue();
        }

        @Bean
        public Queue autoDeleteQueue2()
        {
            return new AnonymousQueue();
        }

        @Bean
        public Binding binding1(FanoutExchange exchange, Queue autoDeleteQueue1)
        {
            return BindingBuilder.bind(autoDeleteQueue1).to(exchange);
        }

        @Bean
        public Binding binding2(FanoutExchange exchange, Queue autoDeleteQueue2)
        {
            return BindingBuilder.bind(autoDeleteQueue2).to(exchange);
        }

        @Bean
        public FanoutReceiver receiver(){
            return new FanoutReceiver();
        }
    }
}
