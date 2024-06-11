package com.Triju.UserService.Controllers;

import com.Triju.UserService.Dto.Users.ActivateUserDto;
import com.Triju.UserService.Dto.Users.RegisterUserDto;
import com.Triju.UserService.Dto.Users.UserDto;
import com.Triju.UserService.Exceptions.PasswordNotMatchException;
import com.Triju.UserService.Exceptions.UserNotFoundException;
import com.Triju.UserService.Services.Implementation.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> createUser(@RequestBody RegisterUserDto registerUserDto) {
        try {
            UserDto createdUser = userService.createUser(registerUserDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
        } catch (PasswordNotMatchException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }

    @PostMapping("/activate-user")
    public ResponseEntity<?> activate(@RequestBody ActivateUserDto activateUserDto) {
        try {
            String message = userService.activateUser(activateUserDto);
            return ResponseEntity.status(HttpStatus.CREATED).body(message);
        } catch (UserNotFoundException exception){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
        } catch (Exception exception){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception.getMessage());
        }
    }
}
