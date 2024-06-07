package com.Triju.UserService.Dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class UserDto {
    private Long id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthDay;
}
