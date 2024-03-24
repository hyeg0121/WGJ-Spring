package com.example.wogeoji.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BasicResponseDto {
    private final Integer isDeleted;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDateTime createdAt;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private final LocalDateTime updatedAt;
}
