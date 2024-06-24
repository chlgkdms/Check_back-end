package com.example.check_backend.domain.subject.exception;

import com.example.check_backend.global.error.exception.BusinessException;
import com.example.check_backend.global.error.exception.ErrorCode;

public class SubjectNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new SubjectNotFoundException();

    private SubjectNotFoundException() {
        super(ErrorCode.SUBJECT_NOT_FOUND);
    }
}
