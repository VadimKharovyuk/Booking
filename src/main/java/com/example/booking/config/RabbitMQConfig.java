package com.example.booking.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    @Bean
    public Queue bookingQueue() {
        return new Queue("bookingQueue", true); // Установить долговечность в true
    }

    @Bean
    public DirectExchange bookingExchange() {
        return new DirectExchange("bookingExchange"); // Обменник типа DIRECT
    }

    @Bean
    public Binding bookingBinding(Queue bookingQueue, DirectExchange bookingExchange) {
        return BindingBuilder.bind(bookingQueue).to(bookingExchange).with("booking"); // Связывание с ключом "booking"
    }
}
