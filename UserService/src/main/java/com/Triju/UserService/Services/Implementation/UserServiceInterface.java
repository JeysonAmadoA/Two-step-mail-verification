package com.Triju.UserService.Services.Implementation;

import com.Triju.UserService.Dto.ActivateUserDto;
import com.Triju.UserService.Dto.RegisterUserDto;
import com.Triju.UserService.Dto.UserDto;
import com.Triju.UserService.Exceptions.PasswordNotMatchException;
import com.Triju.UserService.Exceptions.UserNotFoundException;

public interface UserServiceInterface {

    UserDto createUser(RegisterUserDto userDto) throws PasswordNotMatchException;

    String activateUser(ActivateUserDto activateUserDto) throws UserNotFoundException;
}
