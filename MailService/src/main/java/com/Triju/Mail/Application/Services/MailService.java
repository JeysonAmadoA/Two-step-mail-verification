package com.Triju.Mail.Application.Services;

import com.Triju.Mail.Domain.Dto.Mail.MailDto;
import jakarta.mail.MessagingException;

import java.io.IOException;

public interface MailService {

    void sendSimpleMail(MailDto mailDto);

    void sendHtmlMail(MailDto mailDto) throws MessagingException, IOException;
}
