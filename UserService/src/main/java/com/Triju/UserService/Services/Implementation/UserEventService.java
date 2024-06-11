package com.Triju.UserService.Services.Implementation;

import com.Triju.UserService.Dto.Users.ActivateUserEventDto;

public interface UserEventService {

    void publishEvent(ActivateUserEventDto eventDto);
}
