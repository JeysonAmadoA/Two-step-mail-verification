package com.Triju.UserService.Dto.Users;

import com.Triju.UserService.Dto.Kafka.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class CreateUserEvent extends Event<ActivateUserEventDto> {
}
