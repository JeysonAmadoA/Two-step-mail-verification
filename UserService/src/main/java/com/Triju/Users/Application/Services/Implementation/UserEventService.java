package com.Triju.Users.Application.Services.Implementation;

import com.Triju.Users.Domain.Dto.Users.ActivateUserEventDto;
import com.Triju.Users.Domain.Dto.Users.UserDto;

public interface UserEventService {

    void publishEvent(ActivateUserEventDto eventDto);

    void publishEvent(UserDto eventDto);
}
