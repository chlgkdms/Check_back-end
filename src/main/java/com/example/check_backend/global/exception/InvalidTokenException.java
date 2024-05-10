package com.example.check_backend.global.exception;

import com.example.check_backend.global.error.exception.BusinessException;
import com.example.check_backend.global.error.exception.ErrorCode;

public class InvalidTokenException extends BusinessException {
    public static final BusinessException EXCEPTION = new InvalidTokenException();
    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
