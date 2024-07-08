package com.Triju.Mail.Domain.Dto.Users;

import com.Triju.Mail.Domain.Dto.Kafka.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class CreateUserEvent extends Event<ActivateUserEventDto> {
}
