package com.email.service.producer.config;

import com.email.service.producer.model.enumeration.Queues;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    @Bean
    public Queue criaFila(){
        return new Queue (Queues.enviar_email.toString(), false);
    }

    @Bean
    public RabbitAdmin criarRabbitAdmin(ConnectionFactory connectionFactory){
        return new RabbitAdmin(connectionFactory);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> inicializaAdmin(RabbitAdmin rabbitAdmin){
        return event -> rabbitAdmin.initialize();
    }
}
