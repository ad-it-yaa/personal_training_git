package com.stackroute.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Indicates this as a configuration class
 */
@Configuration
public class RabbitMQConfig {
    /**
     * To get the property values
     */
    @Value("${spring.rabbitmq.queue}")
    private String queue;

    @Value("${spring.rabbitmq.exchange}")
    private String exchange;

    @Value("${spring.rabbitmq.routingkey}")
    private String routingKey;

    @Value("${spring.rabbitmq.username}")
    private String username;

    @Value("${spring.rabbitmq.password}")
    private String password;

    @Value("${spring.rabbitmq.host}")
    private String host;


    /**
     * creating queue
     * durable queue survives a server restart.
     */
    @Bean
    Queue queue() {
        return new Queue(MY_QUEUE, true);
    }


    @Bean
    Exchange myExchange() {
        /**
         * Add code to create Direct Exchange
         */
        return null;
    }


    @Bean
    Binding binding() {
        /**
         * Add code to bind queue and Exchange
         */
        return null;
    }

    /**
     * Creating connections to rabbitMq broker
     */
    @Bean
    ConnectionFactory connectionFactory() {
        /**
         * Add code to create connection to rabbitMq broker
         */

        return null;
    }


    @Bean
    public MessageConverter jsonMessageConverter() {
        /*
         * Jackson2JsonMessageConverter to send the message in a JSON format.
         */
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(jsonMessageConverter());
        return rabbitTemplate;
    }
}
