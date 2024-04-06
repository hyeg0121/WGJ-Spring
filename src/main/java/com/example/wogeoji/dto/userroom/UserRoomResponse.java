package com.example.wogeoji.dto.userroom;

import com.example.wogeoji.entity.UserRoom;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UserRoomResponse {
    private final Long userId;
    private final Long roomId;

    @Builder
    public UserRoomResponse(Long userId, Long roomId) {
        this.userId = userId;
        this.roomId = roomId;
    }

    public static UserRoomResponse from(UserRoom userRoom) {
        return UserRoomResponse.builder()
                .userId(userRoom.getUser().getId())
                .roomId(userRoom.getRoom().getId())
                .build();
    }
}
