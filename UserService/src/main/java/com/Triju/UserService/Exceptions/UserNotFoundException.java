package com.Triju.UserService.Exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super("No se encontró el usuario");
    }
}
