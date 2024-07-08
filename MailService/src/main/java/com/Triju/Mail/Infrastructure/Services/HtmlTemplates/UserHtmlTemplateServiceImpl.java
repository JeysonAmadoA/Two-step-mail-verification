package com.Triju.Mail.Infrastructure.Services.HtmlTemplates;

import com.Triju.Mail.Application.Factories.HtmlTemplateStrategyFactory;
import com.Triju.Mail.Application.Services.HtmlTemplates.UserHtmlTemplateService;
import com.Triju.Mail.Application.Strategies.HtmlTemplateStrategy;
import com.Triju.Mail.Domain.Dto.Kafka.EventType;
import com.Triju.Mail.Domain.Dto.Mail.MailDto;
import org.springframework.stereotype.Service;

@Service
public class UserHtmlTemplateServiceImpl implements UserHtmlTemplateService {

    private final HtmlTemplateStrategyFactory strategyFactory;
    private HtmlTemplateStrategy templateStrategy;

    public UserHtmlTemplateServiceImpl(HtmlTemplateStrategyFactory strategyFactory) {
        this.strategyFactory = strategyFactory;
    }

    @Override
    public void setStrategy(EventType eventType) {
        this.templateStrategy = strategyFactory.getStrategy(eventType);
    }

    @Override
    public String getHtmlContent(MailDto mailDto) {
        if (templateStrategy == null) {
            throw new IllegalStateException("Strategy not set");
        }
        return templateStrategy.generateHtmlTemplate(mailDto);
    }
}
