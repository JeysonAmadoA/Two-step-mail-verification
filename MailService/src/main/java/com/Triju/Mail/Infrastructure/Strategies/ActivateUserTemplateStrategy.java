package com.Triju.Mail.Infrastructure.Strategies;

import com.Triju.Mail.Application.Strategies.HtmlTemplateStrategy;
import com.Triju.Mail.Domain.Dto.Mail.MailDto;
import org.springframework.stereotype.Component;

@Component
public class ActivateUserTemplateStrategy implements HtmlTemplateStrategy {

    @Override
    public String generateHtmlTemplate(MailDto mailDto) {
        return "";
    }
}
