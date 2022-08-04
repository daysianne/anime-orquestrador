package com.animeorquestrador.api.application.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {
    @Bean
    public Queue animeQueue() {
        return new Queue("anime", true);
    }

    @Bean
    DirectExchange exchange() {
        return new DirectExchange("direct-exchange");
    }

    @Bean
    Binding animeBinding(Queue animeQueue, DirectExchange exchange) {
        return BindingBuilder.bind(animeQueue).to(exchange).with("routing-key-anime");
    }

}
