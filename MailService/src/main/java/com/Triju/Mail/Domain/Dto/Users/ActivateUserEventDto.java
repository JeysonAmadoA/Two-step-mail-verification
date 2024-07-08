package com.Triju.Mail.Domain.Dto.Users;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ActivateUserEventDto {
    private Long id;
    private String activationToken;
    private String name;
    private String email;
}
