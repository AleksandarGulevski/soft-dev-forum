package com.example.softdevforum.exception;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(Integer code, String message) {
        super(code, message);
    }
}
