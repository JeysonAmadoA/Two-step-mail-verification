package com.Triju.UserService.Dto.Users;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ActivateUserEventDto {
    private Long id;
    private String activationToken;
    private String name;
    private String email;
}
