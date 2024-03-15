package com.example.wogeoji.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserDto {
    private String name;
    private String email;
    private String password;
}
