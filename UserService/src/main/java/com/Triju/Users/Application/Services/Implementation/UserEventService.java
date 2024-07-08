package com.Triju.Users.Application.Services.Implementation;

import com.Triju.Users.Domain.Dto.Users.ActivateUserEventDto;

public interface UserEventService {

    void publishEvent(ActivateUserEventDto eventDto);
}
