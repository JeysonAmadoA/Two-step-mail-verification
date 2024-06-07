package com.Triju.UserService.Exceptions;

public class PasswordNotMatchException extends Exception{

    public PasswordNotMatchException() {
        super("Las contraseñas no coinciden");
    }
}
