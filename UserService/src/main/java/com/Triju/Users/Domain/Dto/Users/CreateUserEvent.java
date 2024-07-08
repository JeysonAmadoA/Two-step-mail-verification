package com.Triju.Users.Domain.Dto.Users;

import com.Triju.Users.Domain.Dto.Kafka.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateUserEvent extends Event<ActivateUserEventDto> {
}
