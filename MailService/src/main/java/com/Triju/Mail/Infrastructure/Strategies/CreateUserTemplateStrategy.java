package com.Triju.Mail.Infrastructure.Strategies;

import com.Triju.Mail.Application.Strategies.HtmlTemplateStrategy;
import com.Triju.Mail.Domain.Dto.Mail.MailDto;
import com.Triju.Mail.Domain.Dto.Users.ActivateUserEventDto;
import com.Triju.Mail.Domain.Dto.Users.CreateUserEvent;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class CreateUserTemplateStrategy implements HtmlTemplateStrategy {

    private final TemplateEngine templateEngine;

    public CreateUserTemplateStrategy(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public String generateHtmlTemplate(MailDto mailDto) {
        if (mailDto.getData() instanceof CreateUserEvent createUserEvent) {
            ActivateUserEventDto mailData = createUserEvent.getData();
            Context context = new Context();
            context.setVariable("mailData", mailData);
            return templateEngine.process("createUserMailTemplate", context);
        } else {
            throw new IllegalArgumentException("Unsupported event type");
        }
    }
}
