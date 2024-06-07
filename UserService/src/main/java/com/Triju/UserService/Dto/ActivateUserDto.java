package com.Triju.UserService.Dto;

import lombok.Data;

@Data
public class ActivateUserDto {
    private Long id;
    private String activationToken;
}
