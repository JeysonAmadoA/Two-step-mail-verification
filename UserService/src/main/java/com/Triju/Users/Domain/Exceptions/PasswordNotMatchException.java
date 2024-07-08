package com.Triju.Users.Domain.Exceptions;

public class PasswordNotMatchException extends Exception{

    public PasswordNotMatchException() {
        super("Las contraseñas no coinciden");
    }
}
