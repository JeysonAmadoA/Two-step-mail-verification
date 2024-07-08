package com.Triju.Mail.Application.Factories;

import com.Triju.Mail.Application.Strategies.HtmlTemplateStrategy;
import com.Triju.Mail.Domain.Dto.Kafka.EventType;
import com.Triju.Mail.Infrastructure.Strategies.ActivateUserTemplateStrategy;
import com.Triju.Mail.Infrastructure.Strategies.CreateUserTemplateStrategy;
import org.springframework.stereotype.Component;

import java.util.EnumMap;
import java.util.Map;

@Component
public class HtmlTemplateStrategyFactory {

    private final Map<EventType, HtmlTemplateStrategy> strategyMap = new EnumMap<>(EventType.class);

    public HtmlTemplateStrategyFactory(CreateUserTemplateStrategy createUserTemplateStrategy,
                                       ActivateUserTemplateStrategy activateUserTemplateStrategy) {
        strategyMap.put(EventType.CREATED_USER, createUserTemplateStrategy);
        strategyMap.put(EventType.ACTIVATED_USER, activateUserTemplateStrategy);
    }

    public HtmlTemplateStrategy getStrategy(EventType eventType) {
        return strategyMap.get(eventType);
    }
}
