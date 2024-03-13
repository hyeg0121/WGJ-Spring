package com.example.wogeoji.exception.user;

import com.example.wogeoji.exception.BusinessException;
import com.example.wogeoji.exception.ErrorCode;

public class IncorrectPasswordException extends BusinessException {

    public static final BusinessException EXCEPTION = new IncorrectPasswordException();
    private IncorrectPasswordException() { super(ErrorCode.INCORRECT_PASSWORD); }
}
