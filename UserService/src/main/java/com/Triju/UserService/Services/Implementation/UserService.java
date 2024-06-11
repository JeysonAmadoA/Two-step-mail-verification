package com.Triju.UserService.Services.Implementation;

import com.Triju.UserService.Dto.Users.ActivateUserDto;
import com.Triju.UserService.Dto.Users.RegisterUserDto;
import com.Triju.UserService.Dto.Users.UserDto;
import com.Triju.UserService.Exceptions.PasswordNotMatchException;
import com.Triju.UserService.Exceptions.UserNotFoundException;

public interface UserService {

    UserDto createUser(RegisterUserDto userDto) throws PasswordNotMatchException;

    String activateUser(ActivateUserDto activateUserDto) throws UserNotFoundException;
}
