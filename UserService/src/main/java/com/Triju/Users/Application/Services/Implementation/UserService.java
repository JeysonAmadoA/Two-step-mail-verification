package com.Triju.Users.Application.Services.Implementation;

import com.Triju.Users.Domain.Dto.Users.ActivateUserDto;
import com.Triju.Users.Domain.Dto.Users.RegisterUserDto;
import com.Triju.Users.Domain.Dto.Users.UserDto;
import com.Triju.Users.Domain.Exceptions.PasswordNotMatchException;
import com.Triju.Users.Domain.Exceptions.UserNotFoundException;

public interface UserService {

    UserDto createUser(RegisterUserDto userDto) throws PasswordNotMatchException;

    String activateUser(ActivateUserDto activateUserDto) throws UserNotFoundException;
}
