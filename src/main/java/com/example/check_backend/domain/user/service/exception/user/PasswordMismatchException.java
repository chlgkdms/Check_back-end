package com.example.check_backend.domain.user.service.exception.user;

import com.example.check_backend.global.error.exception.BusinessException;
import com.example.check_backend.global.error.exception.ErrorCode;

public class PasswordMismatchException extends BusinessException {
    public static final BusinessException EXCEPTION = new PasswordMismatchException();

    public PasswordMismatchException() {
        super(ErrorCode.PASSWORD_MISMATCH);
    }
}
