package com.example.check_backend.domain.checklist_content.exception;

import com.example.check_backend.global.error.exception.BusinessException;
import com.example.check_backend.global.error.exception.ErrorCode;

public class CheckListContentNotFoundException extends BusinessException {

    public static final BusinessException EXCEPTION = new CheckListContentNotFoundException();

    private CheckListContentNotFoundException() {
        super(ErrorCode.CHECKLIST_CONTENT_NOT_FOUND);
    }
}
