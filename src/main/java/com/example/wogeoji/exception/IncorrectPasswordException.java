package com.example.wogeoji.exception;

public class IncorrectPasswordException extends BusinessException {

    public static final BusinessException EXCEPTION = new IncorrectPasswordException();
    private IncorrectPasswordException() { super(ErrorCode.INCORRECT_PASSWORD); }
}
