package com.styz.security.exception;


import org.springframework.security.core.AuthenticationException;

/**
 * creat date:2019-07-15 23:38
 * author:xxydliuyss
 * note:
 */
public class ValidateCodeException extends AuthenticationException {
    public ValidateCodeException(String message) {
        super(message);
    }
}
