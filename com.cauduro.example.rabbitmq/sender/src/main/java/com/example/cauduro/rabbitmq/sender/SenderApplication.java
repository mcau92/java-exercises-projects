package com.example.cauduro.rabbitmq.sender;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
@SpringBootApplication
public class SenderApplication {

    static final String topicExchangeName = "spring-boot-rabbitmq";

    static final String queueNameListener = "receiver-queue";

    @Bean
    Queue queue() {
        return new Queue(queueNameListener, false);
    }

    @Bean
    TopicExchange exchange() {
        return new TopicExchange(topicExchangeName);
    }

    @Bean
    Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("receiver.key");
    }

    public static void main(String[] args) {
        SpringApplication.run(SenderApplication.class, args);
    }
}
