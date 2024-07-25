package com.Triju.Mail.Domain.Dto.Users;

import com.Triju.Mail.Domain.Dto.Kafka.Event;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class UserActivateSuccessEvent extends Event<UserDto> {}
