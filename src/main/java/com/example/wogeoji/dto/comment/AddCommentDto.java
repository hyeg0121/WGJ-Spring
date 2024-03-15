package com.example.wogeoji.dto.comment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddCommentDto {
    private Long authorId;
    private Long postId;
    private String content;
}
