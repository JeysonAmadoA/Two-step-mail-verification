package com.Triju.UserService.Mappers;

import com.Triju.UserService.Dto.Users.ActivateUserEventDto;
import com.Triju.UserService.Dto.Users.RegisterUserDto;
import com.Triju.UserService.Dto.Users.UserDto;
import com.Triju.UserService.Entities.User;
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
