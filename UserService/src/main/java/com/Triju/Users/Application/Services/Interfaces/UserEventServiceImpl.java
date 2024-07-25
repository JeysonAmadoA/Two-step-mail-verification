package com.Triju.Users.Application.Services.Interfaces;

import com.Triju.Users.Domain.Dto.Kafka.EventType;
import com.Triju.Users.Domain.Dto.Users.ActivateUserEventDto;
import com.Triju.Users.Domain.Dto.Users.CreateUserEvent;
import com.Triju.Users.Application.Services.Implementation.UserEventService;
import com.Triju.Users.Domain.Dto.Users.UserActivateSuccessEvent;
import com.Triju.Users.Domain.Dto.Users.UserDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UserEventServiceImpl implements UserEventService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic.createUser}")
    private String createUserTopic;

    @Value("${kafka.topic.activateUser}")
    private String activateUserTopic;

    public UserEventServiceImpl(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void publishEvent(ActivateUserEventDto eventDto) {
        CreateUserEvent userEvent = new CreateUserEvent();
        userEvent.setData(eventDto);
        userEvent.setId(UUID.randomUUID().toString());
        userEvent.setType(EventType.CREATED_USER);
        userEvent.setDate(new Date());
        this.kafkaTemplate.send(createUserTopic, userEvent);
    }

    public void publishEvent(UserDto eventDto) {
        UserActivateSuccessEvent userEvent = new UserActivateSuccessEvent();
        userEvent.setData(eventDto);
        userEvent.setId(UUID.randomUUID().toString());
        userEvent.setType(EventType.ACTIVATED_USER);
        userEvent.setDate(new Date());
        this.kafkaTemplate.send(activateUserTopic, userEvent);
    }

}
