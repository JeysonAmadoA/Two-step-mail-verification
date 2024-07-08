package com.Triju.Users.Domain.Dto.Users;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class RegisterUserDto {
    private String name;
    private String lastName;
    private LocalDate birthDay;
    private String password;
    private String confirmPassword;
    private String email;
}
