package com.Triju.Users.Domain.Exceptions;

public class UserNotFoundException extends Exception{

    public UserNotFoundException() {
        super("No se encontró el usuario");
    }
}
