package com.example.wogeoji.dto.room;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddRoomDto {
    private Long creatorId;
    private String name;
    private String description;
    private Integer capacity;
}
