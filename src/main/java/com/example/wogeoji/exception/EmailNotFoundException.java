package com.example.wogeoji.exception;

public class EmailNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new EmailNotFoundException();

    private EmailNotFoundException() {
        super(ErrorCode.EMAIL_NOT_FOUND);
    }
}
