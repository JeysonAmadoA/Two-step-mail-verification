package com.Triju.UserService.Services.Interfaces;

import com.Triju.UserService.Dto.Kafka.Event;
import com.Triju.UserService.Dto.Kafka.EventType;
import com.Triju.UserService.Dto.Users.ActivateUserEventDto;
import com.Triju.UserService.Dto.Users.CreateUserEvent;
import com.Triju.UserService.Services.Implementation.UserEventService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserEventServiceImpl implements UserEventService {

    private final KafkaTemplate<String, Event<?>> kafkaTemplate;

    @Value("${kafka.topic.createUser}")
    private String topic;

    public UserEventServiceImpl(KafkaTemplate<String, Event<?>> kafkaTemplate) {
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
