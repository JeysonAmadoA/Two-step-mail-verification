package com.Triju.Mail.Application.Mappers;

import com.Triju.Mail.Domain.Dto.Mail.MailDto;
import com.Triju.Mail.Domain.Dto.Users.CreateUserEvent;
import org.springframework.stereotype.Component;

@Component
public class MailMapper {

    public MailDto createDtoFromEvent(CreateUserEvent event){
        MailDto dto = new MailDto();
        dto.setTo(event.getData().getEmail());
        dto.setSubject("Confirm Mail");
        dto.setBody("Email Confirmation Code: " + event.getData().getActivationToken());
        return dto;
    }
}
