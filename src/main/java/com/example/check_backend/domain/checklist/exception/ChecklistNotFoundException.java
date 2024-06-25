package com.example.check_backend.domain.checklist.exception;

import com.example.check_backend.global.error.exception.BusinessException;
import com.example.check_backend.global.error.exception.ErrorCode;

public class ChecklistNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new ChecklistNotFoundException();

    private ChecklistNotFoundException() {
        super(ErrorCode.CHECKLIST_NOT_FOUND);
    }
}
