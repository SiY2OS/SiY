package org.siy.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicRabbitConfig {

    private final static String routingkey = "siy.topic.#";

    @Bean
    TopicExchange exchange() {
        return new TopicExchange("siy.topic");
    }

    @Bean
    Binding bindingExchangeMessages(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(routingkey);
    }


}
