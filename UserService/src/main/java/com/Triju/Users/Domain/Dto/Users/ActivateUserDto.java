package com.Triju.Users.Domain.Dto.Users;

import lombok.Data;

@Data
public class ActivateUserDto {
    private Long id;
    private String activationToken;
}
