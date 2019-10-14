package com.example.softdevforum.exception;

public class UserAlreadyRegisteredException extends BaseException {

    public UserAlreadyRegisteredException(Integer code, String message) {
        super(code, message);
    }
}
