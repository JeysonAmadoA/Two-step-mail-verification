package com.Triju.Mail.Application.Strategies;

import com.Triju.Mail.Domain.Dto.Mail.MailDto;

public interface HtmlTemplateStrategy {

    String generateHtmlTemplate(MailDto mailDto);
}
