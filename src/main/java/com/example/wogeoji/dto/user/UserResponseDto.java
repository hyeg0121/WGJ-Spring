package com.example.wogeoji.dto.user;

import com.example.wogeoji.dto.BasicResponseDto;
import com.example.wogeoji.entity.User;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class UserResponseDto extends BasicResponseDto {

    private final Long id;
    private final String name;
    private final String email;
    private final String bio;
    private final Integer spentAmount;

    @Builder
    public UserResponseDto(Integer isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, String name, String email, String bio, Integer spentAmount) {
        super(isDeleted, createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.email = email;
        this.bio = bio;
        this.spentAmount = spentAmount;
    }

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .isDeleted(user.getIsDeleted())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .bio(user.getBio())
                .spentAmount(user.getSpentAmount())
                .build();
    }

}
