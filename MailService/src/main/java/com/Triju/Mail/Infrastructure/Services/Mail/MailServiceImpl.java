package com.Triju.Mail.Infrastructure.Services.Mail;

import com.Triju.Mail.Application.Services.MailService;
import com.Triju.Mail.Domain.Dto.Mail.MailDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    public MailServiceImpl(JavaMailSender javaMailSender) {
        this.javaMailSender = javaMailSender;
    }

    @Override
    public void sendSimpleMail(MailDto mailDto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(mailDto.getTo());
        message.setFrom("java@example.com");
        message.setSubject(mailDto.getSubject());
        message.setText(mailDto.getBody());
        this.javaMailSender.send(message);
    }

    @Override
    public void sendHtmlMail(MailDto mailDto, String htmlContent) throws MessagingException{
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        helper.setFrom("java@example.com");
        helper.setTo(mailDto.getTo());
        helper.setSubject(mailDto.getSubject());
        helper.setText(htmlContent, true);
        javaMailSender.send(mimeMessage);
    }

}
