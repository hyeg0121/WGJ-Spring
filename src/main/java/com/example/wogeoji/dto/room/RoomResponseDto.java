package com.example.wogeoji.dto.room;

import com.example.wogeoji.dto.BasicResponseDto;
import com.example.wogeoji.dto.user.UserResponseDto;
import com.example.wogeoji.entity.Room;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class RoomResponseDto extends BasicResponseDto {

    private final Long id;
    private final String name;
    private final UserResponseDto creator;
    private final String description;
    private final Integer capacity;

    @Builder
    public RoomResponseDto(Integer isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, String name, UserResponseDto creator, String description, Integer capacity) {
        super(isDeleted, createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.description = description;
        this.capacity = capacity;
    }

    public static RoomResponseDto from(Room room) {
        UserResponseDto creatorDto = UserResponseDto.from(room.getCreator());
        return RoomResponseDto.builder()
                .isDeleted(room.getIsDeleted())
                .createdAt(room.getCreatedAt())
                .updatedAt(room.getUpdatedAt())
                .id(room.getId())
                .name(room.getName())
                .creator(creatorDto)
                .description(room.getDescription())
                .capacity(room.getCapacity())
                .build();
    }

}
