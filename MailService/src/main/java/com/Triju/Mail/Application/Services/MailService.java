package com.Triju.Mail.Application.Services;

import com.Triju.Mail.Domain.Dto.Mail.MailDto;
import jakarta.mail.MessagingException;

public interface MailService {

    void sendSimpleMail(MailDto mailDto);

    void sendHtmlMail(MailDto mailDto, String htmlContent) throws MessagingException;
}
