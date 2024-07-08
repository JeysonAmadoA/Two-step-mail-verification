package com.Triju.Mail.Domain.Dto.Mail;

import com.Triju.Mail.Domain.Dto.Kafka.Event;
import lombok.Data;

@Data
public class MailDto {
    private String to;
    private String subject;
    private String body;
    private Event<?> data;
}
