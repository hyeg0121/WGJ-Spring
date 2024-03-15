package com.example.wogeoji.dto.post;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddPostDto {
    private Long authorId;
    private Long roomId;
    private Integer amount;
    private String item;
    private String content;
}
