package com.Triju.Mail.Infrastructure.Strategies;

import com.Triju.Mail.Application.Strategies.HtmlTemplateStrategy;
import com.Triju.Mail.Domain.Dto.Mail.MailDto;
import com.Triju.Mail.Domain.Dto.Users.UserActivateSuccessEvent;
import com.Triju.Mail.Domain.Dto.Users.UserDto;
import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Component
public class ActivateUserTemplateStrategy implements HtmlTemplateStrategy {

    private final TemplateEngine templateEngine;

    public ActivateUserTemplateStrategy(TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    @Override
    public String generateHtmlTemplate(MailDto mailDto) {
        if (mailDto.getData() instanceof UserActivateSuccessEvent createUserEvent) {
            UserDto userData = createUserEvent.getData();
            Context context = new Context();
            context.setVariable("userData", userData);
            return templateEngine.process("activateUserMailTemplate", context);
        } else {
            throw new IllegalArgumentException("Unsupported event type");
        }
    }
}
