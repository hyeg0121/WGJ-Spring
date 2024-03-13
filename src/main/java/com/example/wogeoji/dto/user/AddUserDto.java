package com.example.wogeoji.dto.user;

import lombok.Builder;
import lombok.Getter;

@Getter
public class AddUserDto {
    private String name;
    private String email;
    private String password;
}
