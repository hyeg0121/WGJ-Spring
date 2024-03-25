package com.example.wogeoji.dto.post;

import com.example.wogeoji.dto.BasicResponseDto;
import com.example.wogeoji.dto.room.RoomResponseDto;
import com.example.wogeoji.dto.user.UserResponseDto;
import com.example.wogeoji.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto extends BasicResponseDto {
    private final Long id;
    private final UserResponseDto author;
    private final RoomResponseDto room;
    private final Integer amount;
    private final String item;
    private final String content;

    @Builder
    public PostResponseDto(Integer isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, UserResponseDto author, RoomResponseDto room, Integer amount, String item, String content) {
        super(isDeleted, createdAt, updatedAt);
        this.id = id;
        this.author = author;
        this.room = room;
        this.amount = amount;
        this.item = item;
        this.content = content;
    }

    public static PostResponseDto from(Post post) {
        UserResponseDto userResponseDto = UserResponseDto.from(post.getAuthor());
        RoomResponseDto roomResponseDto = RoomResponseDto.from(post.getRoom());

        return PostResponseDto.builder()
                .createdAt(post.getCreatedAt())
                .id(post.getId())
                .author(userResponseDto)
                .room(roomResponseDto)
                .amount(post.getAmount())
                .item(post.getItem())
                .content(post.getContent())
                .build();
    }
}
