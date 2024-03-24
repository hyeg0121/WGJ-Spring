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
    private final String bio;
    private final String profileImagePath;
    private final Integer spentAmount;

    @Builder
    public UserResponseDto(Integer isDeleted, LocalDateTime createdAt, LocalDateTime updatedAt, Long id, String name, String bio, String profileImagePath, Integer spentAmount) {
        super(isDeleted, createdAt, updatedAt);
        this.id = id;
        this.name = name;
        this.bio = bio;
        this.profileImagePath = profileImagePath;
        this.spentAmount = spentAmount;
    }

    public static UserResponseDto from(User user) {
        return UserResponseDto.builder()
                .isDeleted(user.getIsDeleted())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .id(user.getId())
                .name(user.getName())
                .bio(user.getBio())
                .profileImagePath(user.getProfileImagePath())
                .spentAmount(user.getSpentAmount())
                .build();
    }

}
