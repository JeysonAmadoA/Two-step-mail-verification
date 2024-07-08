package com.Triju.Mail.Domain.Dto.Mail;

import lombok.Data;

@Data
public class MailDto {
    private String to;
    private String subject;
    private String body;
}
