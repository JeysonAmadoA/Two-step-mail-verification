package com.Triju.UserService.Helpers;

import com.Triju.UserService.Exceptions.PasswordNotMatchException;

import java.util.Random;

public class UserHelper {

    public static void verifyPassword(String password, String confirmPassword) throws PasswordNotMatchException {
        if (!password.equals(confirmPassword)) {
            throw new PasswordNotMatchException();
        }
    }

    public static String generateTokenCode() {
        Random random = new Random();
        return String.valueOf(100000 + random.nextInt(900000)) ;
    }
}
