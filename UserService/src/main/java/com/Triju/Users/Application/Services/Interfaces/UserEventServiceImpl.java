package com.Triju.Users.Application.Services.Interfaces;

import com.Triju.Users.Domain.Dto.Kafka.Event;
import com.Triju.Users.Domain.Dto.Kafka.EventType;
import com.Triju.Users.Domain.Dto.Users.ActivateUserEventDto;
import com.Triju.Users.Domain.Dto.Users.CreateUserEvent;
import com.Triju.Users.Application.Services.Implementation.UserEventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserEventServiceImpl implements UserEventService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.createUser}")
    private String topic;

    public UserEventServiceImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEvent(ActivateUserEventDto eventDto) {
        CreateUserEvent userEvent = new CreateUserEvent();
        userEvent.setData(eventDto);
        userEvent.setId(UUID.randomUUID().toString());
        userEvent.setType(EventType.CREATED_USER);
        userEvent.setDate(new Date());
        this.kafkaTemplate.send(topic, userEvent);
    }

}
