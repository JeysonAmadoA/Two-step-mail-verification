package com.Triju.Mail.Application.Services.HtmlTemplates;

import com.Triju.Mail.Domain.Dto.Kafka.EventType;
import com.Triju.Mail.Domain.Dto.Mail.MailDto;

public interface HtmlTemplateService {

    void setStrategy(EventType eventType);

    String getHtmlContent(MailDto mailDto);
}
