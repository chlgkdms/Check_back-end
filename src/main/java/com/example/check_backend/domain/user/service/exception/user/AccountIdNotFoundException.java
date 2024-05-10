package com.example.check_backend.domain.user.service.exception.user;

import com.example.check_backend.global.error.exception.BusinessException;
import com.example.check_backend.global.error.exception.ErrorCode;

public class AccountIdNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new AccountIdNotFoundException();

    public AccountIdNotFoundException() {
        super(ErrorCode.USER_NOT_FOUND);
    }
}
