package com.example.wogeoji.exception.user;

import com.example.wogeoji.exception.BusinessException;
import com.example.wogeoji.exception.ErrorCode;

public class DuplicateEmailException extends BusinessException {
    public static final BusinessException EXCEPTION = new DuplicateEmailException();
    private DuplicateEmailException() {
        super(ErrorCode.DUPLICATE_EMAIL);
    }

}
