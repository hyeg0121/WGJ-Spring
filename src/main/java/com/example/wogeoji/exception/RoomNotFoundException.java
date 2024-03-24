package com.example.wogeoji.exception;

public class RoomNotFoundException extends BusinessException {
    public static final BusinessException EXCEPTION = new RoomNotFoundException();
    private RoomNotFoundException() {
        super(ErrorCode.ROOM_NOT_FOUND);
    }
}
