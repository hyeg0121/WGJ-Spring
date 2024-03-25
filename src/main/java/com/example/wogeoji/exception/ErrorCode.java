package com.example.wogeoji.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    // user 인증 관련 Exception
    DUPLICATE_EMAIL(HttpStatus.CONFLICT, "해당 이메일을 사용하는 유저가 존재합니다."),
    INCORRECT_PASSWORD(HttpStatus.UNAUTHORIZED, "비밀번호가 알맞지 않습니다."),
    EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "가입되지 않은 이메일입니다."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "유저가 존재하지 않습니다."),
    ROOM_NOT_FOUND(HttpStatus.NOT_FOUND, "거지방이 존재하지 않습니다."),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "글이 존재하지 않습니다.")
    ;


    private final HttpStatus httpStatus;
    private final String errorMessage;
}
