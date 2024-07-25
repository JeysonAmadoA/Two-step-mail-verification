package com.Triju.Users.Domain.Config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Value("${kafka.topic.activateUser}")
    private String activateUserTopic;

    @Bean
    public NewTopic userActivationTopic() {
        return TopicBuilder.name(activateUserTopic)
                .partitions(3)
                .replicas(1)
                .build();
    }
}
