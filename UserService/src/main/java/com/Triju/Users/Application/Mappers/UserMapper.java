package com.Triju.Users.Application.Mappers;

import com.Triju.Users.Domain.Dto.Users.ActivateUserEventDto;
import com.Triju.Users.Domain.Dto.Users.RegisterUserDto;
import com.Triju.Users.Domain.Dto.Users.UserDto;
import com.Triju.Users.Domain.Entities.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {

    public User DtoToEntity(RegisterUserDto registerUserDto){
        return User.builder()
                .name(registerUserDto.getName())
                .lastName(registerUserDto.getLastName())
                .birthDay(registerUserDto.getBirthDay())
                .email(registerUserDto.getEmail())
                .verifiedUser(false)
                .build();
    }

    public ActivateUserEventDto EntityToDto(User user, String activationToken){
        return ActivateUserEventDto.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .activationToken(activationToken)
                .build();
    }

    public UserDto EntityToDto(User user){
        return UserDto.builder()
                .id(user.getId())
                .name(user.getName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .birthDay(user.getBirthDay())
                .build();
    }
}
