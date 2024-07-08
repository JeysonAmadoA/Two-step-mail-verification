package com.Triju.Mail.Infrastructure.Services;

import com.Triju.Mail.Application.Services.MailService;
import com.Triju.Mail.Domain.Dto.Mail.MailDto;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

@Service
@Slf4j
public class MailServiceImpl implements MailService {

    private final JavaMailSender javaMailSender;

    private final TemplateEngine templateEngine;

    public MailServiceImpl(JavaMailSender javaMailSender, TemplateEngine templateEngine) {
        this.javaMailSender = javaMailSender;
        this.templateEngine = templateEngine;
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
    public void sendHtmlMail(MailDto mailDto) throws MessagingException, IOException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

        helper.setFrom("java@example.com");
        helper.setTo(mailDto.getTo());
        helper.setSubject(mailDto.getSubject());

        Context context = new Context();
        context.setVariable("messageBody", mailDto.getBody());
        String htmlContent = templateEngine.process("createUserMailTemplate", context) ;

//        String htmlTemplate = readFile("templates/createUserMailTemplate.html");
//        String htmlContent = htmlTemplate.replace("{messageBody}", mailDto.getBody());

        helper.setText(htmlContent, true); // true indica que es HTML
        javaMailSender.send(mimeMessage);
    }

    private String readFile(String filePath) throws IOException {
        ClassPathResource resource = new ClassPathResource(filePath);
        byte[] fileBytes = Files.readAllBytes(resource.getFile().toPath());
        return new String(fileBytes, StandardCharsets.UTF_8);
    }
}
