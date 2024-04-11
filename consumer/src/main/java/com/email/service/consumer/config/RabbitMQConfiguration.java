package com.email.service.consumer.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory) {
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin) {
        return event -> rabbitAdmin.initialize();
    }

    @Bean
    public Jackson2JsonMessageConverter messageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, Jackson2JsonMessageConverter jackson2JsonMessageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(messageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Queue filaEnviarEmail() {
        return QueueBuilder.nonDurable("enviar-email").deadLetterExchange("email.deadLetterExchange").build();
    }

    @Bean
    public Queue filaDeadLetterExchnage() {
        return QueueBuilder.nonDurable("enviar-email-dlq").build();
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return ExchangeBuilder.fanoutExchange("email.exchange").build();
    }

    @Bean
    public Binding bindingEnviarEmail() {
        return BindingBuilder.bind(filaEnviarEmail()).to(fanoutExchange());
    }

    @Bean
    public FanoutExchange deadLetterExchnage() {
        return ExchangeBuilder.fanoutExchange("email.deadLetterExchange").build();
    }

    @Bean
    public Binding bindingDeadLetterExchnage() {
        return BindingBuilder.bind(filaDeadLetterExchnage()).to(deadLetterExchnage());
    }
}
