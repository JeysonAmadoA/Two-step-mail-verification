package com.Triju.Mail.Infrastructure.Listeners;

import com.Triju.Mail.Application.Mappers.MailMapper;
import com.Triju.Mail.Application.Services.MailService;
import com.Triju.Mail.Domain.Dto.Mail.MailDto;
import com.Triju.Mail.Domain.Dto.Users.CreateUserEvent;
import jakarta.mail.MessagingException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

import static com.Triju.Mail.Domain.Helper.JsonHelper.getObjectFromJson;

@Component
public class UserListener {

    private final MailService mailService;

    private final MailMapper mailMapper;

    public UserListener(MailService mailService, MailMapper mailMapper) {
        this.mailService = mailService;
        this.mailMapper = mailMapper;
    }

    @KafkaListener(
            topics = "${kafka.topic.createUser}",
            groupId = "group-default"
    )
    public void userCreationListener(String message) throws IOException, MessagingException {
        CreateUserEvent createUserEvent = getObjectFromJson(message, CreateUserEvent.class);
        MailDto mailDto = this.mailMapper.createDtoFromEvent(createUserEvent);
        this.mailService.sendHtmlMail(mailDto);
        System.out.println("Email Sent: " + createUserEvent.getData().getEmail());
    }
}
