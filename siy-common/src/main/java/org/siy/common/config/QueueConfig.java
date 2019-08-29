package org.siy.common.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QueueConfig {

    @Bean
    Queue footprintQueue() {
        return new Queue("siy.topic.footprint");
    }

}
