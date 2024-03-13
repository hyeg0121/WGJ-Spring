package com.example.wogeoji.exception.user;

import com.example.wogeoji.exception.BusinessException;
import com.example.wogeoji.exception.ErrorCode;

public class EmailNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new EmailNotFoundException();

    private EmailNotFoundException() {
        super(ErrorCode.EMAIL_NOT_FOUND);
    }
}
