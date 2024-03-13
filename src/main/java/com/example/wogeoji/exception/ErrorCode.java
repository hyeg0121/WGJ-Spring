package com.example.wogeoji.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DUPLICATE_EMAIL(HttpStatus.CONFLICT, "해당 이메일을 사용하는 유저가 존재합니다."),
    INCORRECT_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 알맞지 않습니다.");


    private final HttpStatus httpStatus;
    private final String errorMessage;
}
