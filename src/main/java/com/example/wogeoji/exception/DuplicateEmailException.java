package com.example.wogeoji.exception;

public class DuplicateEmailException extends BusinessException {
    public static final BusinessException EXCEPTION = new DuplicateEmailException();
    private DuplicateEmailException() {
        super(ErrorCode.DUPLICATE_EMAIL);
    }

}
