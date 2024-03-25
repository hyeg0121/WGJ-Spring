package com.example.wogeoji.exception;

public class PostNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new PostNotFoundException();
    private PostNotFoundException() {
        super(ErrorCode.POST_NOT_FOUND);
    }
}
